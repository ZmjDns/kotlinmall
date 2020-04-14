package com.zmj.kotlinmall.service

import android.Manifest
import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.os.IBinder
import android.support.v4.app.ActivityCompat
import android.support.v4.content.ContextCompat
import android.util.Log
import android.widget.Toast
import com.zmj.base.ui.activity.BaseActivity
import com.zmj.kotlinmall.R
import kotlinx.android.synthetic.main.down_act.*

/**
 * Author : Zmj
 * Blog : https://blog.csdn.net/Zmj_Dns
 * GitHub : https://github.com/ZmjDns
 * Time : 2020/4/14
 * Description :
 */
class DownloadAct: BaseActivity() {

    private var downloadBinder: DownloadService.DownloadBinder? = null

    private val serviceConn: ServiceConnection = object: ServiceConnection{
        override fun onServiceDisconnected(name: ComponentName?) {
            Toast.makeText(this@DownloadAct,"ServiceDisConnect",Toast.LENGTH_SHORT).show()
        }
        override fun onServiceConnected(name: ComponentName?, service: IBinder?) {
            //获取DownloadService中的Binder实例
            downloadBinder = service as DownloadService.DownloadBinder
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.down_act)

        val intent = Intent(this,DownloadService::class.java)
        startService(intent)    //启动服务
        bindService(intent,serviceConn, Context.BIND_AUTO_CREATE)//绑定服务
        if (ContextCompat.checkSelfPermission(this,Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED){
            if (Build.VERSION.SDK_INT >= 23){
                requestPermissions(arrayOf(Manifest.permission.WRITE_EXTERNAL_STORAGE,Manifest.permission.READ_EXTERNAL_STORAGE),1001)
            }
        }

        initClick()
    }

    private fun initClick(){
        begin.setOnClickListener {
            Log.i("DownloadAct","Begin download....")
            val url = "http://192.168.1.254:8080/ACServer/DCWJ.zip"
            downloadBinder!!.startDownload(url)
        }
        stop.setOnClickListener {
            downloadBinder!!.pauseDownload()
        }
        cancel.setOnClickListener {
            downloadBinder!!.cancelDownload()
        }
    }


    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
    }
}