package com.zmj.kotlinmall.media

import android.Manifest
import android.app.Activity
import android.content.ContentUris
import android.content.Intent
import android.graphics.BitmapFactory
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.provider.DocumentsContract
import android.provider.MediaStore
import android.support.v4.app.ActivityCompat
import android.support.v4.content.FileProvider
import android.util.Log
import android.widget.Toast
import com.zmj.base.ui.activity.BaseActivity
import com.zmj.kotlinmall.R
import com.zmj.permissionlibrary.isGetSinglePermission
import kotlinx.android.synthetic.main.act_handle_photo.*
import java.io.File

/**
 * Author : Zmj
 * Blog : https://blog.csdn.net/Zmj_Dns
 * GitHub : https://github.com/ZmjDns
 * Time : 2020/4/15
 * Description :
 */
class HandlePhotoAct: BaseActivity() {

    private val TAKE_PHOTO = 201
    private val OPEN_GALLERY = 202

    private var imageUri: Uri? = null



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.act_handle_photo)

        takePhoto.setOnClickListener {
            //permission()
            takePhoto()
        }

        openGallery.setOnClickListener {
            permission()
        }

        mediaPlayer.setOnClickListener {
            startActivity(Intent(this,MediaPlayerAct::class.java))
        }

    }

    fun permission(){
        if (!isGetSinglePermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE)){
            ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.WRITE_EXTERNAL_STORAGE),101)
        }else{
            openGallery()
        }
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (isGetSinglePermission(this,Manifest.permission.WRITE_EXTERNAL_STORAGE)){
            openGallery()
        }else{
            Toast.makeText(this,"NO permission",Toast.LENGTH_SHORT).show()
        }

    }

    private fun takePhoto(){
        val outputImage = File(externalCacheDir,"output_image.jpeg")
        if (outputImage.exists()){
            outputImage.delete()
        }else{
            outputImage.createNewFile()
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N){
            imageUri = FileProvider.getUriForFile(this,"com.zmj.kotlinmall.fileprovider",outputImage)
        }else{
            imageUri = Uri.fromFile(outputImage)
        }

        val intent = Intent("android.media.action.IMAGE_CAPTURE")
        intent.putExtra(MediaStore.EXTRA_OUTPUT,imageUri)
        startActivityForResult(intent,TAKE_PHOTO)
    }

    private fun openGallery(){
        val intent = Intent("android.intent.action.GET_CONTENT")
        intent.setType("image/*")
        startActivityForResult(intent,OPEN_GALLERY)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode != Activity.RESULT_OK){
            Toast.makeText(this,"获取数据失败",Toast.LENGTH_SHORT).show()
            return
        }
        when(requestCode){
            TAKE_PHOTO -> {
                val photoInStream = contentResolver.openInputStream(imageUri!!)
                if (photoInStream == null){
                    Toast.makeText(this,"获取照片数据失败",Toast.LENGTH_SHORT).show()
                    return
                }
                image.setImageBitmap(BitmapFactory.decodeStream(photoInStream))
            }
            OPEN_GALLERY -> {
                var imagePath: String? = null
                if (data == null){
                    Toast.makeText(this,"获取相册数据失败",Toast.LENGTH_SHORT).show()
                    return
                }
                imagePath = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT){
                    handleImageAfterKitKat(data)
                }else{
                    handleImageBeforeKitKat(data)
                }

                if (imagePath != null){
                    Log.i("HandlePhotoAct","图片路径：$imagePath")
                    image.setImageBitmap(BitmapFactory.decodeFile(imagePath))
                }
            }
        }
    }

    /**
     * 在Android 4.4及以后根据Uri获取图片的路径
     */
    private fun handleImageAfterKitKat(intent: Intent): String? {
        var imagePath: String? = null
        val uri = intent.data ?: return imagePath
        if (DocumentsContract.isDocumentUri(this,uri)){
            //document类型的uir ，则通过Document  id 处理
            val docId = DocumentsContract.getDocumentId(uri)
            if ("com.android.providers.media.documents" == uri.authority){
                val id = docId.split(":")[1]      //解析出数字格式的ID
                val selection = MediaStore.Images.Media._ID + "=" + id
                imagePath = getImagePath(MediaStore.Images.Media.EXTERNAL_CONTENT_URI,selection)
            }else if ("com.android.providers.downloads.documents" == uri.authority){
                val contentUri = ContentUris.withAppendedId(Uri.parse("content://downloads/public_downloads"),docId.toLong())
                imagePath = getImagePath(contentUri,null)
            }
        }else if ("content".equals(uri.scheme,true)){
            //content类型的Uri  则使用普通的方式
            imagePath = getImagePath(uri,null)
        }else if ("file".equals(uri.scheme,true)){
            //file类型的Uri 直接获取图片路径即可
            imagePath = uri.path
        }
        return imagePath
    }

    /**
     * Android 4.4以前获取图片的路径
     */
    private fun handleImageBeforeKitKat(data: Intent): String? {
        val uri = data.data ?: return null

        return getImagePath(uri,null)
    }


    /**
     * 查询获取图片路径
     */
    private fun getImagePath(uri: Uri, selection: String?): String? {
        var path: String? = null
        //通过解析后的Uri，和selection来查询图片的路径
        val cursor = contentResolver.query(uri,null,selection,null,null)
        if (cursor != null){
            if (cursor.moveToFirst()){
                path = cursor.getString(cursor.getColumnIndex(MediaStore.Images.Media.DATA))
            }
            cursor.close()
        }
        return path
    }


}