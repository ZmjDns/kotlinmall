package com.zmj.base.ext

import android.content.Context
import android.os.Build

/**
 * Author : Zmj
 * Blog : https://blog.csdn.net/Zmj_Dns
 * DitHub : https://github.com/ZmjDns
 * Time : 2019/8/8
 * Description :
 */

/**
 * 厂商
 */
fun getMenuFactory(): String{
    return Build.BRAND
}

/**
 *设备型号
 */
fun getTypeNumber(): String{
    return Build.MODEL
}

/**
 * 版本号
 */
fun getVersion(context: Context): Int{
    return context.packageManager.getPackageInfo(context.packageName,0).versionCode
}