package com.zxh.work.ui.presenter

import com.zxh.work.model.api.HttpApi
import com.zxh.work.model.http.HttpErrorHelper
import com.zxh.work.ui.mvpview.RegisterMvpView
import io.reactivex.functions.Consumer
import top.horsttop.appcore.extention.runOnMainThread
import top.horsttop.appcore.extention.subscribeX
import top.horsttop.appcore.ui.base.BasePresenter
import javax.inject.Inject

class RegisterPresenter @Inject constructor(var api: HttpApi) : BasePresenter<RegisterMvpView>() {
    fun register(name: String, password: String) {
        mvpView?.onPost()
        mvpView?.onLoading()
        api.Register(name, password)
            .runOnMainThread()
            .subscribeX(Consumer {
                mvpView?.onPostEnd()
                mvpView?.registerSucess(it)
            }, Consumer {
                mvpView?.onPostEnd()
                HttpErrorHelper.ofMsg(it)
            })
    }
}