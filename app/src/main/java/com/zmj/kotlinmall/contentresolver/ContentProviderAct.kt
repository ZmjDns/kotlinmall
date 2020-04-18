package com.zmj.kotlinmall.contentresolver

import android.Manifest
import android.content.ContentValues
import android.database.Cursor
import android.os.Bundle
import android.provider.ContactsContract
import android.util.Log
import android.widget.Toast
import com.zmj.base.ui.activity.BaseActivity
import com.zmj.kotlinmall.R
import com.zmj.kotlinmall.db.MyDataBaseHelper
import com.zmj.kotlinmall.entry.Contact
import com.zmj.permissionlibrary.isGetSinglePermission
import com.zmj.permissionlibrary.requestSinglePermission
import kotlinx.android.synthetic.main.act_content_provider.*
import java.lang.Exception

/**
 * Author : Zmj
 * Blog : https://blog.csdn.net/Zmj_Dns
 * GitHub : https://github.com/ZmjDns
 * Time : 2020/4/15
 * Description :
 */
class ContentProviderAct: BaseActivity() {

    private val contactLists = ArrayList<Contact>()

    private var dbHelper: MyDataBaseHelper? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.act_content_provider)


        getContacts.setOnClickListener {
            getPermission()
        }

        insert.setOnClickListener {
            insertOneData()
        }

        initDataBase()
    }

    private fun insertOneData() {
        val db = dbHelper?.writableDatabase
        val values = ContentValues()
        /*//添加数据
        values.put("name","The Da Vinci Code")
        values.put("author","Dan Bron")
        values.put("pages",454)
        values.put("price",16.96)
        db?.insert("Book",null,values)
        values.clear()
        //添加第二条
        values.put("name","The Lost Symbol")
        values.put("author","Dan Bron")
        values.put("pages",510)
        values.put("price",19.95)
        db?.insert("Book",null,values)*/

        values.put("category_name","悬疑")
        values.put("category_code",11)
        db?.insert("Category",null,values)

        values.put("category_name","科幻")
        values.put("category_code",12)
        db?.insert("Category",null,values)

        Log.i("ContentProviderAct","insert success")
    }

    private fun getPermission(){
        if (!isGetSinglePermission(this,Manifest.permission.READ_CONTACTS)){
            requestSinglePermission(this,Manifest.permission.READ_CONTACTS,10)
        }else{
           getUserContacts()
        }
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (isGetSinglePermission(this,Manifest.permission.READ_CONTACTS)){
            getUserContacts()
        }else{
            Toast.makeText(this,"拒绝权限",Toast.LENGTH_SHORT).show()
        }
    }

    private fun getUserContacts(){
        val uriString = "content://com.android.contacts"
        var cursor:Cursor? = null// =
        try {
            cursor = contentResolver.query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI,null,null,null,null)
            while (cursor.moveToNext()){
                val name = cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME))
                val phone = cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER))
                contactLists.add(Contact(name,phone))
            }
            cursor.close()
        }catch (e: Exception){
            e.printStackTrace()
        }

        if (contactLists.isNotEmpty()){
            var info = ""
            for (i in contactLists){
                info += i.name + ":${i.phone}\n"
            }

            contactsInfo.text = info
        }
    }


    private fun initDataBase(){
        dbHelper = MyDataBaseHelper(this,"BookStore.db",null,1)

        dbHelper?.writableDatabase
    }

}