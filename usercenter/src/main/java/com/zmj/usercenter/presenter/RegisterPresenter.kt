package com.zmj.usercenter.presenter

import com.zmj.base.presenter.BasePresenter
import com.zmj.base.ui.activity.BaseMvpActivity
import com.zmj.usercenter.presenter.view.RegisterView

/**
 * Author : Zmj
 * Blog : https://blog.csdn.net/Zmj_Dns
 * DitHub : https://github.com/ZmjDns
 * Time : 2019/7/28
 * Description :
 */
class RegisterPresenter: BasePresenter<RegisterView>(){

    fun register(mobile: String,verifyCode: String){

        mView.onRegisterResult(true)
    }
}