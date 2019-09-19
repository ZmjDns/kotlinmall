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
 * Time : 2019/9/19
 * Description :
 */
class LocalReceiver: BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        Log.i("LocalReceiver","我是LocalReceiver...接收到消息：${intent?.action}")
        Toast.makeText(context,"本地广播", Toast.LENGTH_SHORT).show()
    }
}