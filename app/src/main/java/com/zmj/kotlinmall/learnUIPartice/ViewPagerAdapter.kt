package com.zmj.kotlinmall.learnUIPartice

import android.content.Context
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import java.text.FieldPosition

/**
 * Author : Zmj
 * Blog : https://blog.csdn.net/Zmj_Dns
 * DitHub : https://github.com/ZmjDns
 * Time : 2019/10/11
 * Description :
 */
class ViewPagerAdapter : FragmentPagerAdapter {

    lateinit var pageModels: ArrayList<MainUiPracticeAct.PageModel>
    lateinit var context: Context

    constructor(supportFragmentManager: FragmentManager,pageModels: ArrayList<MainUiPracticeAct.PageModel>,context: Context): super(supportFragmentManager){
        this.pageModels = pageModels
        this.context = context
    }

    override fun getItem(position: Int): Fragment {
        val pageModel = pageModels[position]

        return PageFragment.instance(pageModel.sampleLayoutRes,pageModel.practiceLayoutRes)

    }

    override fun getCount(): Int {
        return pageModels.size
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return context.getString(pageModels[position].titleRes)
    }
}