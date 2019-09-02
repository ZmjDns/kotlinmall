package com.zmj.base.injection.module

import android.app.Activity
import dagger.Module
import dagger.Provides

/**
 * Author : Zmj
 * Blog : https://blog.csdn.net/Zmj_Dns
 * DitHub : https://github.com/ZmjDns
 * Time : 2019/9/2
 * Description :
 */
@Module
class ActivityModule(private val activity: Activity) {
    @Provides
    fun providesActivity(): Activity{
        return activity
    }
}