package com.zmj.usercenter.service

import io.reactivex.Observable

/**
 * Author : Zmj
 * Blog : https://blog.csdn.net/Zmj_Dns
 * DitHub : https://github.com/ZmjDns
 * Time : 2019/7/28
 * Description :
 */
interface UserService {

    fun register(monile: String,verifyCode: String,pwd: String): Observable<Boolean>
}