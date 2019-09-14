package com.zmj.base.dbproxy

import java.lang.reflect.InvocationHandler
import java.lang.reflect.Method
import java.lang.reflect.Proxy

/**
 * Author : Zmj
 * Blog : https://blog.csdn.net/Zmj_Dns
 * DitHub : https://github.com/ZmjDns
 * Time : 2019/9/14
 * Description :
 */
class FilmCompany {

    fun createFilm(){
        val filmProxy = FilmProxy("AVActor")

        filmProxy.playFilm()
    }

    fun dynamicProxy(){
        val proxy = Proxy.newProxyInstance(Actor::class.java.classLoader, arrayOf(IPlay::class.java),object :InvocationHandler{
            override fun invoke(proxy: Any?, method: Method?, args: Array<out Any>?): Any {

                return proxy as IPlay
            }
        }) as IPlay

        proxy.playFilm()
    }
}