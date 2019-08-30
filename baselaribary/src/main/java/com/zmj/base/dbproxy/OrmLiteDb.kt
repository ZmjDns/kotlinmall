package com.zmj.base.dbproxy

/**
 * Author : Zmj
 * Blog : https://blog.csdn.net/Zmj_Dns
 * DitHub : https://github.com/ZmjDns
 * Time : 2019/8/30
 * Description :
 */
class OrmLiteDb: IOperateData {

    val TAG: String = javaClass.name

    override fun addData() {
        println("$TAG Add Data。。。。")
    }

    override fun queryData() {
        println("$TAG Query Data。。。。")
    }

    override fun updateData() {
        println("$TAG Update Data。。。。")
    }

    override fun deleteData() {
        println("$TAG Delete Data。。。。")
    }
}