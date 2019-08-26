package com.zmj.base.model

import com.zmj.base.data.entry.AppInfo
import com.zmj.base.data.net.ApiService
import com.zmj.base.data.net.IResponse
import com.zmj.base.data.net.RetrofitFactory
import com.zmj.base.exception.MDebug
import com.zmj.base.presenter.view.IAppUpdateView
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.io.File
import java.lang.Exception

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
    fun downloadNewVersionApk(newVersionPath: String,savePath: String,listener: IAppUpdateView){
        MainScope().launch(Dispatchers.IO) {
            kotlin.runCatching {
                RetrofitFactory.instance.create(ApiService::class.java).getApkFile(newVersionPath)
            }.onSuccess {
                val apkDir = File(savePath)
                if (!apkDir.exists()){
                    apkDir.mkdirs()
                }
                val apkFile = File(savePath + "update.apk")
                if(apkFile.exists()){
                    apkFile.delete()
                }

                val body = it.body()
                if (it.isSuccessful && body != null){
                    try {
                        apkFile.writeBytes(body.byteStream().readBytes())
                        //下载完成之后切到主线程更新
                        withContext(Dispatchers.Main){
                            listener.onDownloaded(apkFile.absolutePath)
                        }
                    }catch (e: Exception){
                        MDebug.instance?.writeException("downloadNewVersionApk",e)
                    }
                }
            }.onFailure {
                listener.onFailed(it)
            }
        }
    }
}