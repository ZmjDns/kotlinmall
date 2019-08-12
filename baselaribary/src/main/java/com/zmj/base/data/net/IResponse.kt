package com.zmj.base.data.net

/**
 * Author : Zmj
 * Blog : https://blog.csdn.net/Zmj_Dns
 * DitHub : https://github.com/ZmjDns
 * Time : 2019/8/12
 * Description :
 */
interface IResponse<T> {
    fun onSuccess(response: T)

    fun onFailed(throwable: Throwable)
}