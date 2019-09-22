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

        println("静态代理。。。。。。")
        filmProxy.playFilm()
    }

    /**
     * 动态代理
     */
    fun dynamicProxy(){
        val actor = Actor("hha")
        val proxy = Proxy.newProxyInstance(Actor::class.java.classLoader, arrayOf(IPlay::class.java),object :InvocationHandler{
            override fun invoke(proxy: Any?, method: Method?, args: Array<out Any>?): Any? {
                val result = method?.invoke(actor,*args.orEmpty())
                return result
            }
        }) as IPlay

        proxy.playFilm()

//        val actor = Actor("haha")
//        val proxy = Proxy.newProxyInstance(Actor::class.java.classLoader, arrayOf(IPlay::class.java),DynamicProxyHandler(actor)) as IPlay
//
//        println("动态代理。。。。。。")
//        proxy.playFilm()
    }
}