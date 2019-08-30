package com.zmj.base.dbproxy

/**
 * Author : Zmj
 * Blog : https://blog.csdn.net/Zmj_Dns
 * DitHub : https://github.com/ZmjDns
 * Time : 2019/8/30
 * Description :数据库代理类
 */
class DbProxy:IOperateData {

    private var proxy :IOperateData

    constructor(){
        //this.proxy = LitePalDb()
        this.proxy = OrmLiteDb()
    }

    override fun addData() {
        proxy.addData()
    }

    override fun queryData() {
        proxy.queryData()
    }

    override fun updateData() {
        proxy.updateData()
    }

    override fun deleteData() {
        proxy.deleteData()
    }
}