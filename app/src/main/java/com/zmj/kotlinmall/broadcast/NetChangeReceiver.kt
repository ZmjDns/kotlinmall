package com.zmj.kotlinmall.broadcast

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log
import android.widget.Toast

/**
 * Author : Zmj
 * Blog : https://blog.csdn.net/Zmj_Dns
 * DitHub : https://github.com/ZmjDns
 * Time : 2019/9/18
 * Description :
 */
class NetChangeReceiver: BroadcastReceiver(){

    override fun onReceive(context: Context?, intent: Intent?) {

        Log.i("NetChangeReceiver","接收到广播了，action：${intent?.action}")
        Toast.makeText(context,"网络改变",Toast.LENGTH_SHORT).show()
        //阻断有序广播的继续发送
        abortBroadcast()

    }

}