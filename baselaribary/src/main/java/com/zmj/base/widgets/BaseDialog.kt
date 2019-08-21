package com.zmj.base.widgets

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.view.View
import com.zmj.base.R
import kotlinx.android.synthetic.main.base_dialog.*

/**
 * Author : Zmj
 * Blog : https://blog.csdn.net/Zmj_Dns
 * DitHub : https://github.com/ZmjDns
 * Time : 2019/8/21
 * Description : 基本的dialog头和中间部分
 */
abstract class BaseDialog(context: Context): Dialog(context) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.base_dialog)

        ll_body.addView(getBodyView())
    }

    abstract fun getBodyView(): View
}