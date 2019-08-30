package com.zmj.usercenter.presenter

import com.zmj.base.dbproxy.DbProxy
import com.zmj.base.presenter.BasePresenter
import com.zmj.usercenter.presenter.view.RegisterView
import com.zmj.usercenter.service.impl.UserServiceImpl

/**
 * Author : Zmj
 * Blog : https://blog.csdn.net/Zmj_Dns
 * DitHub : https://github.com/ZmjDns
 * Time : 2019/7/28
 * Description :
 */
class RegisterPresenter: BasePresenter<RegisterView>(){

    fun register(mobile: String,verifyCode: String,pwd: String){
        /**
         * 业务逻辑
         */
        val userService = UserServiceImpl()
        /*userService.register(mobile,verifyCode,pwd)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())*/
        val dbProxy = DbProxy()

        dbProxy.queryData()
        dbProxy.deleteData()

        mView.onRegisterResult(true)
    }
}