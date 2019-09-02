package com.zmj.base.injection.component

import android.content.Context
import com.zmj.base.injection.ActivityScope
import com.zmj.base.injection.module.ActivityModule
import dagger.Component

/**
 * Author : Zmj
 * Blog : https://blog.csdn.net/Zmj_Dns
 * DitHub : https://github.com/ZmjDns
 * Time : 2019/9/2
 * Description :
 */
@ActivityScope
@Component(dependencies = arrayOf(AppComponent::class),modules = arrayOf(ActivityModule::class))
interface ActivityComponent {
    fun context(): Context
}