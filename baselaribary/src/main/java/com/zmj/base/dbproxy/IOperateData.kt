package com.zmj.base.dbproxy

/**
 * Author : Zmj
 * Blog : https://blog.csdn.net/Zmj_Dns
 * DitHub : https://github.com/ZmjDns
 * Time : 2019/8/30
 * Description :数据库操作数据接口
 */
interface IOperateData {
    fun addData()

    fun queryData()

    fun updateData()

    fun deleteData()
}