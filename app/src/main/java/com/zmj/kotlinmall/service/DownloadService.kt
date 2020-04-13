package com.zmj.kotlinmall.service

import android.app.Service
import android.content.Intent
import android.os.Binder
import android.os.IBinder

/**
 * Author : Zmj
 * Blog : https://blog.csdn.net/Zmj_Dns
 * GitHub : https://github.com/ZmjDns
 * Time : 2020/4/13
 * Description :
 */
class DownloadService: Service() {

    private val mBinder = DownloadBinder()
    var downloadTask: DownloadTask? = null
    //状态监听
    private val downloadListener = object :IDownloadListener{

        override fun onProgress(progress: Int) {
        }

        override fun onSuccess() {
        }

        override fun onFailed() {
        }

        override fun onPaused() {

        }

        override fun onCanceled() {

        }

    }


    override fun onBind(intent: Intent?): IBinder? {
        return mBinder
    }

    override fun onDestroy() {
        super.onDestroy()
    }


    inner class DownloadBinder: Binder(){

        fun startDownload(){
            if (downloadTask == null){
                downloadTask = DownloadTask(downloadListener)
            }
            downloadTask!!.execute("http://192.168.1.254:8050/")
        }

        fun pauseDownload(){

        }

        fun cancelDownload(){

        }

    }


}