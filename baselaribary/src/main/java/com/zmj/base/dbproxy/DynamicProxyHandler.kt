package com.zmj.base.dbproxy

import java.lang.reflect.InvocationHandler
import java.lang.reflect.Method

/**
 * Author : Zmj
 * Blog : https://blog.csdn.net/Zmj_Dns
 * DitHub : https://github.com/ZmjDns
 * Time : 2019/9/16
 * Description : 动态代理处理器
 */
class DynamicProxyHandler: InvocationHandler{

    private var traget: Any

    constructor(target: Any){
        this.traget = target
    }


    override fun invoke(proxy: Any?, method: Method?, args: Array<out Any>?): Any? {
        println("执行之前....")
        val result = method?.invoke(traget,*args.orEmpty())

        println("执行之后....")

        return result
    }
}