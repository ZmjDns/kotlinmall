package com.zmj.kotlinmall.learnUIPartice

import android.os.Bundle
import android.support.annotation.LayoutRes
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.zmj.kotlinmall.R
import kotlinx.android.synthetic.main.fragment_page.*

/**
 * Author : Zmj
 * Blog : https://blog.csdn.net/Zmj_Dns
 * DitHub : https://github.com/ZmjDns
 * Time : 2019/10/10
 * Description :
 */
class PageFragment: Fragment() {

    @LayoutRes var sampleLayoutRes: Int? = null
    @LayoutRes var practiceLayoutRes: Int? = null

    companion object instance{
        fun instance( @LayoutRes sampleLayoutRes: Int,@LayoutRes practiceLayoutRes: Int): PageFragment{
            val pageFragment = PageFragment()
            val bundle = Bundle()
            bundle.putInt("sampleLayoutRes",sampleLayoutRes)
            bundle.putInt("practiceLayoutRes",practiceLayoutRes)

            pageFragment.arguments = bundle

            return pageFragment
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (arguments != null){
            val bundle = arguments as Bundle
            sampleLayoutRes = bundle.getInt("sampleLayoutRes")
            practiceLayoutRes = bundle.getInt("practiceLayoutRes")
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_page,container)

        sampleStub.inflatedId = sampleLayoutRes!!
        sampleStub.inflate()

        practiceStub.inflatedId = practiceLayoutRes!!
        practiceStub.inflate()

        return view
    }









    override fun onDestroy() {
        super.onDestroy()
    }
}