package com.zmj.base.injection.module

import android.content.Context
import com.zmj.base.common.BaseApplication
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Author : Zmj
 * Blog : https://blog.csdn.net/Zmj_Dns
 * DitHub : https://github.com/ZmjDns
 * Time : 2019/9/2
 * Description :
 */
@Module
class AppModule(private val context: BaseApplication) {

    @Provides
    @Singleton
    fun providesContext(): Context{
        return context
    }
}