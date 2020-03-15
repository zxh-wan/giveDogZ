package com.zxh.work.ui.mvpview

import com.zxh.work.pojo.RegisterVo
import top.horsttop.appcore.ui.base.MvpView

interface RegisterMvpView :MvpView {
    fun  registerSucess(user:RegisterVo)
}