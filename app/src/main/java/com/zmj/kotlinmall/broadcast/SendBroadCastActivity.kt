package com.zmj.kotlinmall.broadcast

import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import android.support.v4.content.LocalBroadcastManager
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.zmj.kotlinmall.R
import kotlinx.android.synthetic.main.activity_main.*

/**
 * Author : Zmj
 * Blog : https://blog.csdn.net/Zmj_Dns
 * DitHub : https://github.com/ZmjDns
 * Time : 2019/9/18
 * Description :
 */
class SendBroadCastActivity: AppCompatActivity() {

    private var netChangeReceiver : NetChangeReceiver? = null
    private var localBroadcastManager: LocalBroadcastManager? = null
    private var localReceiver: LocalReceiver? = null

    private var receiveNetBroadcastByStatic: ReceiveNetBroadcastByStatic? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        sendMyBroadCast()

        /*btn_sendLocalBC.setOnClickListener {
            sendLocalBroadCast()
        }*/

        //sendLocalBroadCast()
        //在oncreate方法中注册
        //dynamicRegisterBroadCast()
        //selfBroadcast()
    }

    private fun sendMyBroadCast(){
        //动态注册
        val  intentFilter = IntentFilter("com.zmj.kotlinmall.MY_ACTION")
        netChangeReceiver = NetChangeReceiver()
        registerReceiver(netChangeReceiver,intentFilter, "com.zmj.kotlinmall.SEND_NET_INFO",null)
        Log.i("sendMyBroadCast","广播已经注册完成")
        val intent = Intent("com.zmj.kotlinmall.MY_ACTION")
        sendBroadcast(intent,"com.zmj.kotlinmall.RECEIVE_NET_INFO")
        //sendOrderedBroadcast(intentFilter,Manifest.permission.SEND_NET_INFO)
        Log.i("sendMyBroadCast","广播已经发出去......")
    }

    private fun selfBroadcast(){
        //注意，一定要要先注册，再发送广播，否则可能接收不到
        //动态注册
        receiveNetBroadcastByStatic = ReceiveNetBroadcastByStatic()
        val intentFilter = IntentFilter("com.zmj.test.DIY_BROADCSAT")
        registerReceiver(receiveNetBroadcastByStatic,intentFilter)
        //发送广播
        val intent = Intent("com.zmj.test.DIY_BROADCSAT")
        //sendBroadcast(intent)
        sendOrderedBroadcast(intent,null)
    }

    private fun dynamicRegisterBroadCast(){
        val intent = IntentFilter("android.net.conn.CONNECTIVITY_CHANGE")
        receiveNetBroadcastByStatic = ReceiveNetBroadcastByStatic()
        registerReceiver(receiveNetBroadcastByStatic,intent)
    }


    //发送本地广播
    private fun sendLocalBroadCast(){
        localBroadcastManager = LocalBroadcastManager.getInstance(this)

        val intentFilter = IntentFilter()
        intentFilter.addAction("com.zmj.kotlinmall.LOCAL_BROADCAST")
        localReceiver = LocalReceiver()
        localBroadcastManager!!.registerReceiver(localReceiver!!,intentFilter)
        Log.i("SendBroadCastActivity","广播已经注册完成......")
        val intent = Intent("com.zmj.kotlinmall.LOCAL_BROADCAST")
        localBroadcastManager!!.sendBroadcast(intent)
        Log.i("SendBroadCastActivity","广播已经发出去......")
    }



    override fun onDestroy() {
        //unregisterReceiver(netChangeReceiver)
        if(localBroadcastManager != null && netChangeReceiver != null){
            localBroadcastManager?.unregisterReceiver(netChangeReceiver!!)
        }
        //一定要在界面销毁的时候解除注册
        unregisterReceiver(receiveNetBroadcastByStatic)
        super.onDestroy()
    }
}