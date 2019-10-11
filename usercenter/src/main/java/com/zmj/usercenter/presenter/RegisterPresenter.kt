package com.zmj.usercenter.presenter

import com.zmj.base.common.execute
import com.zmj.base.dbproxy.DbProxy
import com.zmj.base.dbproxy.FilmCompany
import com.zmj.base.presenter.BasePresenter
import com.zmj.usercenter.presenter.view.RegisterView
import com.zmj.usercenter.service.UserService
import com.zmj.usercenter.service.impl.UserServiceImpl
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

/**
 * Author : Zmj
 * Blog : https://blog.csdn.net/Zmj_Dns
 * DitHub : https://github.com/ZmjDns
 * Time : 2019/7/28
 * Description :注册presenter引入Dagger2
 */
class RegisterPresenter @Inject constructor(): BasePresenter<RegisterView>(){

    @Inject
    lateinit var userService: UserService
    fun register(mobile: String,verifyCode: String,pwd: String){
        /**
         * 业务逻辑
         */
        //val userService = UserServiceImpl()
        /*userService.register(mobile,verifyCode,pwd)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())*/
        val dbProxy = DbProxy()

        dbProxy.queryData()
        dbProxy.deleteData()

        val filmCompany = FilmCompany()

        filmCompany.createFilm()
        filmCompany.dynamicProxy()

        /*userService.register(mobile,verifyCode,pwd)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe()

        mView.onRegisterResult(true)*/
    }
}