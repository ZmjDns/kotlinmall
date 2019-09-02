package com.zmj.base.common

import android.app.Application
import com.zmj.base.injection.component.AppComponent
import com.zmj.base.injection.component.DaggerAppComponent
import com.zmj.base.injection.module.AppModule

/**
 * Author : Zmj
 * Blog : https://blog.csdn.net/Zmj_Dns
 * DitHub : https://github.com/ZmjDns
 * Time : 2019/9/2
 * Description :
 */
class BaseApplication: Application() {

    lateinit var appComponent: AppComponent
    override fun onCreate() {
        super.onCreate()

        initAppInjection()
    }

    private fun initAppInjection() {
        appComponent = DaggerAppComponent.builder().appModule(AppModule(this)).build()
    }
}