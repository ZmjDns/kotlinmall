package com.zmj.base.rx

import org.reactivestreams.Subscriber
import org.reactivestreams.Subscription

/**
 * Author : Zmj
 * Blog : https://blog.csdn.net/Zmj_Dns
 * DitHub : https://github.com/ZmjDns
 * Time : 2019/7/29
 * Description : 重写Subscribe
 */
open class BaseSubscribe<T>: Subscriber<T> {

    override fun onComplete() {

    }

    override fun onSubscribe(s: Subscription?){

    }

    override fun onNext(t: T) {

    }

    override fun onError(t: Throwable?) {

    }
}