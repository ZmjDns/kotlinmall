package com.zmj.usercenter.data.repository

import com.zmj.base.data.net.RetrofitFactory
import com.zmj.base.data.protocol.BaseResp
import com.zmj.usercenter.data.api.UserApi
import com.zmj.usercenter.data.protocol.RegisterReq
import rx.Observable
import javax.inject.Inject

/**
 * Author : Zmj
 * Blog : https://blog.csdn.net/Zmj_Dns
 * DitHub : https://github.com/ZmjDns
 * Time : 2019/8/31
 * Description :
 */
class UserRepository @Inject constructor() {

    fun register(mobile: String,pwd: String,verifyCode: String): Observable<BaseResp<String>>{
        return RetrofitFactory.instance.create(UserApi::class.java).register(RegisterReq(mobile,pwd,verifyCode))
    }
}