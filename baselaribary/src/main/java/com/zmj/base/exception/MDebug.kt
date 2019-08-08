package com.zmj.base.exception

import com.zmj.base.ext.getNowTime
import java.io.File
import java.lang.Exception

/**
 * Author : Zmj
 * Blog : https://blog.csdn.net/Zmj_Dns
 * DitHub : https://github.com/ZmjDns
 * Time : 2019/8/7
 * Description : bug收集
 */
class MDebug {
    private var debugFile: File? = null

    private constructor(fileName: String){
        debugFile = File(fileName)
    }

    companion object{
        @Volatile
        var instance: MDebug? = null

        fun getInstance(fileName: String): MDebug{
            if (instance == null){
                synchronized(MDebug::class){
                    if (instance == null){
                        MDebug(fileName)
                    }
                }
            }
            return instance!!
        }
    }

    fun writeInfo(tag: String,info: String){
        writeStringToFile("$tag:  $info")
    }

    fun writeThrowable(tag: String,throwable: Throwable){
        writeStringToFile("$tag:  ${throwable.message}")
    }

    fun writeException(tag: String,exception: Exception){
        writeStringToFile("$tag:  ${exception.message}")
    }

    @Synchronized private fun writeStringToFile(content: String){
        val str = "${getNowTime()}:  $content"
        if (isFileOK()){
            debugFile!!.appendText(str)
        }
    }

    private fun isFileOK(): Boolean{
        if (debugFile != null){
            if (debugFile!!.exists()){
                return debugFile!!.canWrite()
            }
        }
        return false
    }
}