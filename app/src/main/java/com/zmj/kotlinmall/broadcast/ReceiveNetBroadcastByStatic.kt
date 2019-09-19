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
//接收网络变化的广播接收器
class ReceiveNetBroadcastByStatic: BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        //打印接收到的action
        Log.i("staticRegister","Received action： ${intent?.action}")
        Toast.makeText(context,"收到广播 ${intent?.action}", Toast.LENGTH_SHORT).show()
    }
}