package com.zmj.base.dbproxy

/**
 * Author : Zmj
 * Blog : https://blog.csdn.net/Zmj_Dns
 * DitHub : https://github.com/ZmjDns
 * Time : 2019/9/14
 * Description :
 */
class Actor: IPlay {
    private var name: String
    constructor(name: String){
        this.name = name
    }
    override fun playFilm() {
        println("The actor $name is playing film")
    }
}