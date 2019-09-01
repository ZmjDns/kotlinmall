package com.zmj.usercenter.injection.component

import com.zmj.usercenter.injection.model.UserModule
import com.zmj.usercenter.ui.activity.RegisterActivity
import dagger.Component

/**
 * Author : Zmj
 * Blog : https://blog.csdn.net/Zmj_Dns
 * DitHub : https://github.com/ZmjDns
 * Time : 2019/9/1
 * Description :
 */
@Component(modules = arrayOf(UserModule::class))
interface UserComponent {
    fun inject(activity:RegisterActivity)
}