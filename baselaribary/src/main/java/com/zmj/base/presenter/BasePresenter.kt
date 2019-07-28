package com.zmj.base.presenter

import com.zmj.base.presenter.view.BaseView

/**
 * Author : Zmj
 * Blog : https://blog.csdn.net/Zmj_Dns
 * DitHub : https://github.com/ZmjDns
 * Time : 2019/7/28
 * Description :
 */
class BasePresenter<T: BaseView> {

    lateinit var mView: T
}