package com.zmj.kotlinmall.service

import android.os.Binder

/**
 * Author : Zmj
 * Blog : https://blog.csdn.net/Zmj_Dns
 * GitHub : https://github.com/ZmjDns
 * Time : 2020/4/13
 * Description :监听下载状态的接口
 */
interface IDownloadListener {

    fun onProgress(progress: Int)

    fun onSuccess()

    fun onFailed()

    fun onPaused()

    fun onCanceled()
}