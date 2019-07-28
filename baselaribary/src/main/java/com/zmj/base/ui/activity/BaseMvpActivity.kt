package com.zmj.base.ui.activity

import com.zmj.base.presenter.BasePresenter
import com.zmj.base.presenter.view.BaseView

/**
 * Author : Zmj
 * Blog : https://blog.csdn.net/Zmj_Dns
 * DitHub : https://github.com/ZmjDns
 * Time : 2019/7/28
 * Description :
 */
open class BaseMvpActivity<T:BasePresenter<*>>: BaseActivity(),BaseView {
    override fun showLoading() {
    }

    override fun hideLoading() {
    }

    override fun onError() {
    }

    lateinit var mPresenter: T

}