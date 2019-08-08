package com.zmj.base

import android.app.Application
import com.zmj.base.exception.MDebug
import com.zmj.base.ext.getMenuFactory
import com.zmj.base.ext.getTypeNumber

/**
 * Author : Zmj
 * Blog : https://blog.csdn.net/Zmj_Dns
 * DitHub : https://github.com/ZmjDns
 * Time : 2019/8/8
 * Description :
 */
class MyBaseApp: Application() {

    override fun onCreate() {
        super.onCreate()





        //开启捕捉日志
        val debufilePaths =  cacheDir.absolutePath + "/" + getMenuFactory() + "_" + getTypeNumber() + ".txt"
        MDebug.getInstance(debufilePaths)
    }
}