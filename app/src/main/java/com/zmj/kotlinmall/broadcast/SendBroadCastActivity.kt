package com.zmj.kotlinmall.broadcast

import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.zmj.kotlinmall.Manifest
import com.zmj.kotlinmall.R

/**
 * Author : Zmj
 * Blog : https://blog.csdn.net/Zmj_Dns
 * DitHub : https://github.com/ZmjDns
 * Time : 2019/9/18
 * Description :
 */
class SendBroadCastActivity: AppCompatActivity() {

    private var netChangeReceiver : NetChangeReceiver? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        sendBroadCast()
    }

    private fun sendBroadCast(){
        val  intentFilter = Intent("com.zmj.kotlinmall.MY_ACTION")
        netChangeReceiver = NetChangeReceiver()
        //registerReceiver(netChangeReceiver,intentFilter,Manifest.permission.SEND_NET_INFO,null)
        sendOrderedBroadcast(intentFilter,Manifest.permission.SEND_NET_INFO)
        Log.i("SendBroadCastActivity","广播已经发出去......")
    }

    override fun onDestroy() {
        //unregisterReceiver(netChangeReceiver)
        super.onDestroy()
    }
}