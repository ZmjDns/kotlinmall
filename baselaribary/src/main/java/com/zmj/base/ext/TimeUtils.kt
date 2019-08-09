package com.zmj.base.ext

import android.os.Build
import java.text.SimpleDateFormat
import java.util.*

/**
 * Author : Zmj
 * Blog : https://blog.csdn.net/Zmj_Dns
 * DitHub : https://github.com/ZmjDns
 * Time : 2019/8/8
 * Description :
 */

fun getNowTime() : String{
    if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.N){
        return SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.CANADA).format(Date())
    }else{
        val tms = Calendar.getInstance()
        return tms.get(Calendar.YEAR).toString() + "-" + tms.get(Calendar.MONTH) + "-" + tms.get(Calendar.DAY_OF_MONTH) + " " + tms.get(
            Calendar.HOUR_OF_DAY) + ":" + tms.get(Calendar.MINUTE) + ":" + tms.get(Calendar.SECOND)
    }
}