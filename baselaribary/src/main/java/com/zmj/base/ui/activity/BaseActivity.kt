package com.zmj.base.ui.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity

/**
 * Author : Zmj
 * Blog : https://blog.csdn.net/Zmj_Dns
 * DitHub : https://github.com/ZmjDns
 * Time : 2019/7/27
 * Description :
 */
abstract class BaseActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(layoutId)
    }



    protected  abstract val layoutId: Int


    override fun onDestroy() {
        super.onDestroy()
    }
}