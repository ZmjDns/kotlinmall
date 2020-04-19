package com.zmj.kotlinmall.notification

import android.annotation.TargetApi
import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.graphics.BitmapFactory
import android.graphics.Color
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.service.notification.StatusBarNotification
import android.support.v4.app.NotificationCompat
import com.zmj.base.ui.activity.BaseActivity
import com.zmj.kotlinmall.R
import kotlinx.android.synthetic.main.act_notification.*
import java.io.File
import java.lang.StringBuilder

/**
 * Author : Zmj
 * Blog : https://blog.csdn.net/Zmj_Dns
 * GitHub : https://github.com/ZmjDns
 * Time : 2020/4/14
 * Description :实现各种通知的用法，以及Android8.0以上的适配
 */
class NotificationAct: BaseActivity(){

    private lateinit var notificationManager: NotificationManager

    private val channelId = "myNotificationId"
    private val channelName = "myNotification"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.act_notification)

        notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            createNotificationChannel(channelId,channelName,NotificationManager.IMPORTANCE_DEFAULT)
        }


        initClick()

        //去掉通知方法
        notificationManager.cancel(2)
    }

    override fun onResume() {
        super.onResume()
    }

    private fun initClick(){
        baseNotification.setOnClickListener {
            val notification = getBaseNotification("this is title","this is content").build()
            notificationManager.notify(2,notification)
        }

        notifyIntent.setOnClickListener {
            val notificationIntent = getNotifyIntent("Title","content",80)/*.setAutoCancel(true)*/.build()
            notificationManager.notify(2,notificationIntent)
            //notificationManager.notify(3,notificationIntent)
        }

        advance.setOnClickListener {
            val notification = getAdvanceNotification("title","content",60).build()
            notificationManager.notify(2,notification)
        }

        advanced.setOnClickListener {
            val notification = getAdvancedNotification().build()

            notificationManager.notify(2,notification)
        }
    }

    //基础用法
    private fun getBaseNotification(title: String,content: String): NotificationCompat.Builder{
        val builder = NotificationCompat.Builder(this,channelId)

        builder.setContentTitle(title)
        builder.setContentText(content)
        builder.setSmallIcon(R.drawable.ic_launcher_background)
        builder.setLargeIcon(BitmapFactory.decodeResource(resources,R.drawable.batman))
        builder.setWhen(System.currentTimeMillis())
        //builder.setShowWhen(true)

        return builder
    }

    //Act处理用法
    private fun getNotifyIntent(title: String,content: String,progress: Int): NotificationCompat.Builder{

        val builder = getBaseNotification(title,content)

        builder.setProgress(100,progress,true)
        val intent = Intent(this,NotificationAct::class.java)
        val pendingIntent = PendingIntent.getActivity(this,0,intent,0)
        builder.setContentIntent(pendingIntent)

        return builder
    }

    //进阶用法
    private fun getAdvanceNotification(title: String,content: String,progress: Int): NotificationCompat.Builder{
        val builder = getNotifyIntent(title,content, progress)

        //builder.setSound(Uri.fromFile(File("/system/media/audio/ringtones/Luna.ogg")))
        //builder.setVibrate(longArrayOf(0,1000,1000,1000))
        builder.setLights(Color.GREEN,1000,1000)

        return builder
    }

    //高级用法
    private fun getAdvancedNotification():NotificationCompat.Builder{
        val builder = getAdvanceNotification("title","",20)

        builder.setStyle(NotificationCompat.BigTextStyle().bigText("ndicoewhfiewhfioe nidowhefihefihewi hifwhefiwehfiohefhbhfiewfhiwhf nfiwhfhqaifjaijf ifhfiafioafaifao"))

        //builder.setStyle(NotificationCompat.BigPictureStyle().bigPicture(BitmapFactory.decodeResource(resources,R.drawable.sample_pie_chart)))

        builder.priority = NotificationCompat.PRIORITY_MAX

        return builder
    }


    //对Android8.0的通知进行适配
    @TargetApi(Build.VERSION_CODES.O)
    private fun createNotificationChannel(channelId: String, channelName: String, importance: Int){
        val notificationChannel = NotificationChannel(channelId,channelName,importance)
        notificationManager.createNotificationChannel(notificationChannel)
    }




}