package com.zmj.base.data.net

import com.zmj.base.data.entry.AppInfo
import com.zmj.base.data.entry.BaseResponse
import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Streaming

/**
 * Author : Zmj
 * Blog : https://blog.csdn.net/Zmj_Dns
 * DitHub : https://github.com/ZmjDns
 * Time : 2019/8/12
 * Description :
 */
interface ApiService {
    @GET()
    suspend fun getAppVersionInfo(): BaseResponse<AppInfo>

    @Streaming
    @GET("app{apkName}")
    suspend fun getApkFile(@Path("apkName") apkName: String): Response<ResponseBody>
}