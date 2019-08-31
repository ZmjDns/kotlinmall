package com.zmj.base.data.protocol

/**
 * Author : Zmj
 * Blog : https://blog.csdn.net/Zmj_Dns
 * DitHub : https://github.com/ZmjDns
 * Time : 2019/8/31
 * Description :基础相应数据控制
 */
class BaseResp<out T>(status: Int,message: String,data: T)