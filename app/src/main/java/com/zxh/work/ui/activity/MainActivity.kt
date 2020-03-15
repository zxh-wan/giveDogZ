package com.zxh.work.ui.activity


import android.content.Intent
import android.view.View

import com.zxh.work.R
import com.zxh.work.core.App
import com.zxh.work.di.component.DaggerViewComponent

import com.zxh.work.pojo.LoginVo
import com.zxh.work.ui.mvpview.LoginMvpView
import com.zxh.work.ui.presenter.LoginPersenter
import kotlinx.android.synthetic.main.activity_main.*
import top.horsttop.appcore.core.GenApp
import top.horsttop.appcore.extention.startActivity
import top.horsttop.appcore.ui.base.BaseActivity
import top.horsttop.appcore.util.PreferencesHelper
import top.horsttop.appcore.util.toast.ToastUtil
import java.util.regex.Pattern
import javax.inject.Inject

class MainActivity : BaseActivity(), LoginMvpView {
    override fun loginSucess(user: LoginVo?) {
        if (user?.data == null) {
            ToastUtil.showShort("登录失败")
            return
        }
        if (user.code == 200) {
            GenApp.instance.preferencesHelper.saveConfig(user.data.name!!, user.data.name!!)
            GenApp.instance.preferencesHelper.saveConfig(
                user.data.name!! + "phone",
                user.data.phone
            )
            GenApp.instance.preferencesHelper.saveConfig(
                user.data.name!! + "address",
                user.data.address
            )
            GenApp.instance.preferencesHelper.saveConfig(
                user.data.name!! + "sex",
                user.data.sex

            )
            ToastUtil.showShort("登录成功")
            startActivity(
                Intent(this@MainActivity, UserActivity::class.java).putExtra(
                    "name",
                    user.data.name

                )
            )

//                    GenApp.instance.preferencesHelper.saveConfig("address", user.data?.address)
        } else {
            ToastUtil.showShort("登录失败")
        }
    }

    override val contentViewId: Int = R.layout.activity_main

    override fun initViews() {
//        input_name.setText(GenApp.instance.preferencesHelper.getStringConfig("name"))
        btn_login.setOnClickListener(this)
        btn_register.setOnClickListener(this)
    }

    override fun onActivityInject() {
        DaggerViewComponent.builder()
            .appComponent(App.appComponent)
            .build()
            .inject(this)
        mPresenter.attachView(this)
    }

    @Inject
    lateinit var mPresenter: LoginPersenter


    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btn_login -> {
                var name = input_name.text.toString()
                var password = input_password.text.toString()
                val ps = "^[a-zA-Z0-9]{6,16}$"
                val p = Pattern.compile(ps)
                val m = p.matcher(password)
                // return m.matches()
                if (!m.matches()) {
                    ToastUtil.showShort("密码格式不正确！")
                    return
                }

                if (name.isNullOrEmpty()) {
                    ToastUtil.showShort("用户不能为空")
                    return
                }
                if (password.isNullOrEmpty()) {
                    ToastUtil.showShort("密码不能为空")
                    return
                }
                if (password.length < 6) {
                    ToastUtil.showShort("密码长度不能小于6")
                    return
                }
                mPresenter.login(name, password)
            }
            R.id.btn_register -> {
                startActivity(v, RegisterActivity::class.java)
            }
        }

    }


}