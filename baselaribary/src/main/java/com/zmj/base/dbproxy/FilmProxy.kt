package com.zmj.base.dbproxy

/**
 * Author : Zmj
 * Blog : https://blog.csdn.net/Zmj_Dns
 * DitHub : https://github.com/ZmjDns
 * Time : 2019/9/14
 * Description :
 */
class FilmProxy : IPlay {
    private var actor: Actor

    constructor(name: String){
        this.actor = Actor(name)
    }
    override fun playFilm() {
        actor.playFilm()
    }
}