package com.zmj.base.data.net

import com.zmj.base.data.entry.AppInfo
import com.zmj.base.data.entry.BaseResponse
import retrofit2.http.GET

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
}