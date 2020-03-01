package com.zmj.base.ui.activity

import android.os.Bundle
import com.zmj.base.common.BaseApplication
import com.zmj.base.injection.component.ActivityComponent
import com.zmj.base.injection.component.DaggerActivityComponent
import com.zmj.base.injection.module.ActivityModule
import com.zmj.base.presenter.BasePresenter
import com.zmj.base.presenter.view.BaseView
import javax.inject.Inject

/**
 * Author : Zmj
 * Blog : https://blog.csdn.net/Zmj_Dns
 * DitHub : https://github.com/ZmjDns
 * Time : 2019/7/28
 * Description :
 */
open class BaseMvpActivity<T:BasePresenter<*>>: BaseActivity(),BaseView {

    override fun onError(throwable: Throwable) {
    }

    override fun showLoading() {
    }

    override fun hideLoading() {
    }

    @Inject     //引入Dagger
    lateinit var mPresenter: T

    lateinit var activityComponent: ActivityComponent

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //initActivityInjection()
    }

    private fun initActivityInjection() {
        activityComponent = DaggerActivityComponent.builder().appComponent((application as BaseApplication).appComponent).activityModule(
            ActivityModule(this)
        ).build()
    }

}