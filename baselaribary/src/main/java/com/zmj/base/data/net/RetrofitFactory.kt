package com.zmj.base.data.net

import com.zmj.base.common.BaseConstant
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
 * Author : Zmj
 * Blog : https://blog.csdn.net/Zmj_Dns
 * DitHub : https://github.com/ZmjDns
 * Time : 2019/7/29
 * Description :Retrofit模板配置
 */
class RetrofitFactory private constructor(){
    companion object{
        val instance: RetrofitFactory by lazy { RetrofitFactory() }
    }

    private val retrofit: Retrofit
    private val interceptor: Interceptor    //header 相关的拦截器
    init {

        interceptor = Interceptor {
            chan ->
            val request = chan.request()
                .newBuilder()
                .addHeader("Content-Type","application/json")
                .addHeader("charset","utf-8")
                .build()
            chan.proceed(request)
        }

        retrofit = Retrofit.Builder()
            .baseUrl(BaseConstant.Server_address)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
            .client(initClient())
            .build()
    }

    private fun initClient(): OkHttpClient {
        return OkHttpClient.Builder()
                .addNetworkInterceptor(interceptor)     //header 相关拦截器
                .addInterceptor(initInterceptor())      //日志相关的拦截器
                .connectTimeout(10,TimeUnit.SECONDS)
                .readTimeout(10,TimeUnit.SECONDS)
                .build()
    }

    //日志拦截器
    private fun initInterceptor(): Interceptor {
        val interceptor = HttpLoggingInterceptor()

        interceptor.level = HttpLoggingInterceptor.Level.BODY

        return interceptor
    }

    fun <T> create(service: Class<T>): T{
        return retrofit.create(service)
    }
}