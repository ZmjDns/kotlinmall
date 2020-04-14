package com.zmj.kotlinmall.service

import android.app.Notification
import android.app.NotificationManager
import android.app.PendingIntent
import android.app.Service
import android.content.Context
import android.content.Intent
import android.graphics.BitmapFactory
import android.os.Binder
import android.os.Environment
import android.os.IBinder
import android.support.v4.app.NotificationCompat
import android.util.Log
import android.view.accessibility.AccessibilityManager
import android.widget.Toast
import com.zmj.kotlinmall.R
import com.zmj.kotlinmall.ui.activity.MainActivity
import retrofit2.Retrofit
import java.io.File

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
    private var downloadUrl: String? = null

    private var isDownloading: Boolean = false
    //状态监听
    private val downloadListener = object :IDownloadListener{

        override fun onProgress(progress: Int) {
            getNotificationManager().notify(1,getNotification("Downloading...",progress))
        }

        override fun onSuccess() {
            downloadTask = null

            getNotificationManager().notify(1,getNotification("Download Success",-1))
            Toast.makeText(this@DownloadService,"Download Success",Toast.LENGTH_SHORT).show()
        }

        override fun onFailed() {
            //下载失败将前台的服务通知关闭，并创建一个下载失败的通知
            stopForeground(true)
            getNotificationManager().notify(1,getNotification("Download Failed",-1))
            Toast.makeText(this@DownloadService,"Download Failed",Toast.LENGTH_SHORT).show()
        }

        override fun onPaused() {
            downloadTask = null
            Toast.makeText(this@DownloadService,"Pause",Toast.LENGTH_SHORT).show()
        }

        override fun onCanceled() {
            downloadTask = null
            stopForeground(true)
            Toast.makeText(this@DownloadService,"Canceled",Toast.LENGTH_SHORT).show()
        }
    }


    override fun onCreate() {
        super.onCreate()
        Log.i("DownloadService","onCreate....")
    }


    override fun onBind(intent: Intent?): IBinder? {
        Log.i("DownloadService","onBind....")
        return mBinder
    }

    override fun onDestroy() {
        Log.i("DownloadService","onDestroy....")
        super.onDestroy()
    }


    inner class DownloadBinder: Binder(){

        fun startDownload(url: String){
            if (isDownloading){
                Toast.makeText(this@DownloadService,"正在下载中，请勿重复下载",Toast.LENGTH_SHORT).show()
                return
            }
            if (downloadTask == null){
                downloadTask = DownloadTask(downloadListener)
            }
            downloadUrl = url
            downloadTask!!.execute(url)
            //前台通知
            startForeground(1,getNotification("Dowlading...",0))
            Toast.makeText(this@DownloadService,"Begin downloading....",Toast.LENGTH_SHORT).show()
            isDownloading = true
        }

        fun pauseDownload(){
            if (downloadTask != null){
                downloadTask!!.pauseDownload()
                isDownloading = false
            }
        }

        fun cancelDownload(){
            if (downloadTask != null){
                downloadTask!!.cancelDownload()
            }
            if (downloadUrl != null){
                //取消下载时，删除文件并将通知关闭
                val fileName = downloadUrl!!.substring(downloadUrl!!.lastIndexOf("/"))
                val file = File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).path + fileName)
                if (file.exists()){
                    file.delete()
                }
                //关闭通知
                getNotificationManager().cancel(1)
                stopForeground(true)
                Toast.makeText(this@DownloadService,"canceled download",Toast.LENGTH_SHORT).show()
                isDownloading = false
            }
        }
    }

    private fun getNotificationManager(): NotificationManager{
        return getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
    }

    private fun getNotification(title: String,progress: Int): Notification {
        val intent = Intent(this,DownloadAct::class.java)
        val pendingIntent = PendingIntent.getActivity(this,0,intent,0)
        val notificationBuilder = NotificationCompat.Builder(this,"100")
        notificationBuilder.setSmallIcon(R.mipmap.ic_launcher)
        notificationBuilder.setLargeIcon(BitmapFactory.decodeResource(resources,R.mipmap.ic_launcher))
        notificationBuilder.setContentIntent(pendingIntent)
        notificationBuilder.setContentTitle(title)
        //if (progress > 0){
            //当progress > 0 时显示
            notificationBuilder.setContentText("$progress%")
            notificationBuilder.setProgress(100,progress,false)
        //}
        return notificationBuilder.build()
    }
}