package com.zmj.base.widgets

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.TextView
import com.zmj.base.R

/**
 * Author : Zmj
 * Blog : https://blog.csdn.net/Zmj_Dns
 * DitHub : https://github.com/ZmjDns
 * Time : 2019/8/21
 * Description : 确认框
 */
class ConformDialog(context: Context): BaseDialog(context) {

    private var conform: TextView? = null
    private var cancel: TextView? = null

    private var tv_msgContent : TextView? = null
    override var bodyView: View
        get() = body()
        set(value) {}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    fun body(): View{
        val body = LayoutInflater.from(context).inflate(R.layout.conform_dialog,null)

        conform = body.findViewById(R.id.btn_conform)
        cancel = body.findViewById(R.id.btn_cancel)
        tv_msgContent = body.findViewById(R.id.tv_msgContent)
        return body
    }

    fun setBodyInfo(content: String){
        tv_msgContent!!.text = content
    }
}