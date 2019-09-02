package com.zmj.base.injection.component

import android.content.Context
import com.zmj.base.injection.module.AppModule
import dagger.Component
import javax.inject.Singleton

/**
 * Author : Zmj
 * Blog : https://blog.csdn.net/Zmj_Dns
 * DitHub : https://github.com/ZmjDns
 * Time : 2019/9/2
 * Description :
 */
@Singleton
@Component(modules = arrayOf(AppModule::class))
interface AppComponent {

    fun context(): Context
}