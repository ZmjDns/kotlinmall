package com.zmj.usercenter.ui.activity

import android.os.Bundle
import android.widget.Toast
import com.zmj.base.ui.activity.BaseActivity
import com.zmj.base.ui.activity.BaseMvpActivity
import com.zmj.usercenter.R
import com.zmj.usercenter.injection.component.DaggerUserComponent
import com.zmj.usercenter.injection.model.UserModule
import com.zmj.usercenter.presenter.RegisterPresenter
import com.zmj.usercenter.presenter.view.RegisterView
import kotlinx.android.synthetic.main.register_act.*
import javax.inject.Inject

/**
 * Author : Zmj
 * Blog : https://blog.csdn.net/Zmj_Dns
 * DitHub : https://github.com/ZmjDns
 * Time : 2019/7/27
 * Description :
 */
class RegisterActivity: BaseMvpActivity<RegisterPresenter>(),RegisterView{
    override fun onRegisterResult(result: Boolean) {
        Toast.makeText(this,"$result",Toast.LENGTH_SHORT).show()
    }


//    override val layoutId: Int
////        get() = R.layout.register_act

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.register_act)

        mPresenter = RegisterPresenter()
        mPresenter.mView = this
        //initInjection()

        register.setOnClickListener { mPresenter.register("","","") }
    }

//    private fun initInjection() {
//        DaggerUserComponent.builder().userModule(UserModule()).build().inject(this)
//        mPresenter.mView = this
//    }
}