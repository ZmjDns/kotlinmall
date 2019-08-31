package com.zmj.usercenter.service.impl

import com.zmj.usercenter.data.repository.UserRepository
import com.zmj.usercenter.service.UserService
import io.reactivex.Observable

/**
 * Author : Zmj
 * Blog : https://blog.csdn.net/Zmj_Dns
 * DitHub : https://github.com/ZmjDns
 * Time : 2019/7/28
 * Description :
 */
class UserServiceImpl: UserService {
    override fun register(monile: String, verifyCode: String, pwd: String): Observable<Boolean> {
        val repository = UserRepository()

        repository.register(monile,pwd,verifyCode)//.flatMap {  }
        return Observable.just(true)
    }
}