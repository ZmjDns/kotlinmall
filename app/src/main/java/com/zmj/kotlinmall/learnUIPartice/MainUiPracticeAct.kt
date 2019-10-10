package com.zmj.kotlinmall.learnUIPartice

import android.os.Bundle
import android.os.PersistableBundle
import android.support.annotation.LayoutRes
import android.support.annotation.StringRes
import android.support.v7.app.AppCompatActivity
import com.zmj.kotlinmall.R
import kotlinx.android.synthetic.main.act_main_ui_practice.view.*

/**
 * Author : Zmj
 * Blog : https://blog.csdn.net/Zmj_Dns
 * DitHub : https://github.com/ZmjDns
 * Time : 2019/10/10
 * Description :
 */
class MainUiPracticeAct: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.act_main_ui_practice)


    }


    override fun onDestroy() {
        super.onDestroy()
    }



    class PageModel{
        @LayoutRes var sampleLayoutRes: Int
        @StringRes var titleRes: Int
        @LayoutRes var practiceLayoutRes: Int

        constructor(@LayoutRes sampleLayoutRes: Int,@StringRes titleRes: Int,@LayoutRes practiceLayoutRes: Int){
            this.sampleLayoutRes = sampleLayoutRes
            this.titleRes = titleRes
            this.practiceLayoutRes = practiceLayoutRes
        }
    }
}