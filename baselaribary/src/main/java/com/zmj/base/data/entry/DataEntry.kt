package com.zmj.base.data.entry

/**
 * Author : Zmj
 * Blog : https://blog.csdn.net/Zmj_Dns
 * DitHub : https://github.com/ZmjDns
 * Time : 2019/8/12
 * Description :
 */

data class BaseResponse<T>(var responseCode:Int,
                           var responseInfo:String,
                           var data: T)

data class AppInfo(var versionCode: Int,
                   var versionName: String,
                   var versionUrl: String)

