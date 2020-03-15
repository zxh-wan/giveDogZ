package com.zxh.work.ui.activity

import android.view.View
import com.zxh.work.R
import kotlinx.android.synthetic.main.activity_user.*
import top.horsttop.appcore.core.GenApp
import top.horsttop.appcore.extention.startActivity
import top.horsttop.appcore.ui.base.BaseActivity

class UserActivity : BaseActivity() {
    override val contentViewId: Int = R.layout.activity_user


    override fun initViews() {
        val stringExtra = intent.getStringExtra("name")
        if (!stringExtra.isNullOrEmpty()) {
            tv_values.setText(GenApp.instance.preferencesHelper.getStringConfig(stringExtra))
            tv_address.setText(GenApp.instance.preferencesHelper.getStringConfig(stringExtra + "address"))
            tv_phone.setText(GenApp.instance.preferencesHelper.getStringConfig(stringExtra + "phone"))
            tv_sex.setText(GenApp.instance.preferencesHelper.getStringConfig(stringExtra + "sex"))
        }
        back.setOnClickListener(this)

    }

    override fun onActivityInject() {
    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.back ->{
                startActivity(v, MainActivity::class.java)
            }
        }
    }
}