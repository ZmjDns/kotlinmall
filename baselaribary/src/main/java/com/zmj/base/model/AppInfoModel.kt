package com.zmj.base.model

import com.zmj.base.data.entry.AppInfo
import com.zmj.base.data.net.ApiService
import com.zmj.base.data.net.IResponse
import com.zmj.base.data.net.RetrofitFactory
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch

/**
 * Author : Zmj
 * Blog : https://blog.csdn.net/Zmj_Dns
 * DitHub : https://github.com/ZmjDns
 * Time : 2019/8/10
 * Description :app版本信息，更新功能
 */
class AppInfoModel {
    //获取版本信息
    fun getAppVersion(listener: IResponse<AppInfo>){
        MainScope().launch(Dispatchers.IO) {
            kotlin.runCatching {
                RetrofitFactory.instance.create(ApiService::class.java).getAppVersionInfo()
            }.onSuccess {
                listener.onSuccess(it.data)
            }.onFailure {
                listener.onFailed(it)
            }
        }
    }

    //下载Apk
    fun downloadNewVersionApk(){
        MainScope().launch(Dispatchers.IO) {
            kotlin.runCatching {

            }.onSuccess {

            }.onFailure {

            }
        }
    }
}