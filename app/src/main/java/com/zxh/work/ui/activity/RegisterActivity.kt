package com.zxh.work.ui.activity

import android.content.Intent
import android.util.Log
import android.view.View
import com.zxh.work.R
import com.zxh.work.core.App
import com.zxh.work.core.App.Companion.list
import com.zxh.work.di.component.DaggerViewComponent
import com.zxh.work.pojo.RegisterVo
import com.zxh.work.pojo.RegisterbeanVo
import com.zxh.work.ui.mvpview.RegisterMvpView
import com.zxh.work.ui.presenter.RegisterPresenter
import kotlinx.android.synthetic.main.activity_register.*
import top.horsttop.appcore.core.GenApp
import top.horsttop.appcore.extention.startActivity
import top.horsttop.appcore.ui.base.BaseActivity
import top.horsttop.appcore.util.toast.ToastUtil
import javax.inject.Inject

class RegisterActivity : BaseActivity(), RegisterMvpView {
    override fun registerSucess(user: RegisterVo) {
        if (user.code == 200) {
            ToastUtil.showShort("注册成功")
    //        list?.add(user.data)
//            val stringMap: HashMap<String, String> = hashMapOf()
//            stringMap.put("name", user.data?.name!!)
//            stringMap.put("password", user.data?.password!!)
            startActivity(Intent(this@RegisterActivity, MainActivity::class.java))
            finish()
        } else
            ToastUtil.showShort("注册失败")
    }

    override val contentViewId: Int = R.layout.activity_register


    override fun initViews() {
        btn_register.setOnClickListener(this)
        back.setOnClickListener(this)
    }

    @Inject
    lateinit var mPresenter: RegisterPresenter

    override fun onActivityInject() {
        DaggerViewComponent.builder()
            .appComponent(App.appComponent)
            .build()
            .inject(this)
        mPresenter.attachView(this)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btn_register -> {
                var name = register_name.text.toString()
                var password = register_password.text.toString()
                var aginpasword = register_again_password.text.toString()
                if (name.isNullOrEmpty()) {
                    ToastUtil.showShort("用户不能为空")
                    return
                }
                if (password.isNullOrEmpty()) {
                    ToastUtil.showShort("密码不能为空")
                    return
                }
                if (aginpasword.isNullOrEmpty()) {
                    ToastUtil.showShort("请再次输入密码")
                    return
                }
                if (password.length < 6) {
                    ToastUtil.showShort("密码长度不能小于6")
                    return
                }
                if (!password.equals(aginpasword)) {
                    ToastUtil.showShort("两次输入的密码不一致")
                    return
                }
                mPresenter.register(name, password)

            }
            R.id.back -> {
                startActivity(v, MainActivity::class.java)
            }
        }
    }
}