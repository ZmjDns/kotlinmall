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

fun getAndroidVersion(): String{
    var infoStr = ""
    infoStr += "MANUFACTURER: ${Build.MANUFACTURER} \n"
    infoStr += "MODEL: ${Build.MODEL} \n"
    infoStr += "SDK: ${Build.VERSION.SDK_INT} \n"
    infoStr += "VERSION.RELEASE: ${Build.VERSION.RELEASE} \n"
    infoStr += "PRODUCT: ${Build.PRODUCT} \n"
    infoStr += "CPU_ABI: ${Build.CPU_ABI} \n"
    infoStr += "TAGS: ${Build.TAGS} \n"
    infoStr += "VERSION_CODES.BASE: ${Build.VERSION_CODES.BASE} \n"
    infoStr += "DEVICE: ${Build.DEVICE} \n"
    infoStr += "DISPLAY: ${Build.DISPLAY} \n"
    infoStr += "BOARD: ${Build.BOARD} \n"
    infoStr += "ID: ${Build.ID} \n"
    infoStr += "USER: ${Build.USER}"
    return infoStr
}