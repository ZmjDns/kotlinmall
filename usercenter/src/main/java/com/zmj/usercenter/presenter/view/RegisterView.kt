package com.zmj.usercenter.presenter.view

import com.zmj.base.presenter.view.BaseView

/**
 * Author : Zmj
 * Blog : https://blog.csdn.net/Zmj_Dns
 * DitHub : https://github.com/ZmjDns
 * Time : 2019/7/28
 * Description :
 */
interface RegisterView: BaseView {
    fun onRegisterResult(result: Boolean)
}