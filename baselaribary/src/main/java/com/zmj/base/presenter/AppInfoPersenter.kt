package com.zmj.base.presenter

import com.zmj.base.data.entry.AppInfo
import com.zmj.base.data.net.IResponse
import com.zmj.base.model.AppInfoModel
import com.zmj.base.presenter.view.AppVersionView
import com.zmj.base.presenter.view.BaseView
import com.zmj.base.presenter.view.IAppUpdateView

/**
 * Author : Zmj
 * Blog : https://blog.csdn.net/Zmj_Dns
 * DitHub : https://github.com/ZmjDns
 * Time : 2019/8/11
 * Description : 获取app信息Persenter
 */
class AppInfoPersenter:BasePresenter<AppVersionView>() {

    private val appInfoModel: AppInfoModel by lazy { AppInfoModel() }

    fun getAppInfo(){
        mView.showLoading()
        appInfoModel.getAppVersion(object :IResponse<AppInfo>{
            override fun onSuccess(response: AppInfo) {
                mView.onGetVersion(response)
            }
            override fun onFailed(throwable: Throwable) {
                mView.onError(throwable)
            }
        })
    }

    //apk下载
    fun downloadNewAppVersion(newVersion: String,savePath: String){
        appInfoModel.downloadNewVersionApk(newVersion,savePath,object: IAppUpdateView{
            override fun downloadProcess(process: Int) {

            }
            override fun onDownloaded(apkPath: String) {

            }

            override fun onFailed(throwable: Throwable) {

            }

        })
    }
}