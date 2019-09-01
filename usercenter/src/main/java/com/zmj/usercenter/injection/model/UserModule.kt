package com.zmj.usercenter.injection.model

import com.zmj.usercenter.service.UserService
import com.zmj.usercenter.service.impl.UserServiceImpl
import dagger.Module
import dagger.Provides

/**
 * Author : Zmj
 * Blog : https://blog.csdn.net/Zmj_Dns
 * DitHub : https://github.com/ZmjDns
 * Time : 2019/9/1
 * Description :用于实例没有构造方法的类如：接口
 */
@Module
class UserModule {

    /**
     * 用Provides通过接口的实现类来实现接口实例
     *  @param service
     */
    @Provides
    fun providesUserService(service: UserServiceImpl): UserService{
        return service
    }
}