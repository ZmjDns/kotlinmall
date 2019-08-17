package com.zmj.base.presenter.view

import com.zmj.base.data.entry.AppInfo

/**
 * Author : Zmj
 * Blog : https://blog.csdn.net/Zmj_Dns
 * DitHub : https://github.com/ZmjDns
 * Time : 2019/7/28
 * Description :
 */
interface BaseView {
    fun showLoading()
    fun hideLoading()
    fun onError(throwable: Throwable)
}

interface AppVersionView:BaseView{
    fun onGetVersion(appInfo: AppInfo)
}