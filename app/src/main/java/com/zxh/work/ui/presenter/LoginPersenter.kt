package com.zxh.work.ui.presenter

import android.util.Log
import com.zxh.work.model.api.HttpApi
import com.zxh.work.model.http.HttpErrorHelper
import com.zxh.work.ui.mvpview.LoginMvpView
import io.reactivex.functions.Consumer
import top.horsttop.appcore.extention.runOnMainThread
import top.horsttop.appcore.extention.subscribeX
import top.horsttop.appcore.ui.base.BasePresenter
import javax.inject.Inject

class LoginPersenter @Inject constructor(var api: HttpApi) : BasePresenter<LoginMvpView>() {
    fun login(name: String, password: String) {
      //  Log.d("xxxxxxxxxxxxxxx",name.toString()+password.toString())
        mvpView?.onPost()
        mvpView?.onLoading()
        api.Login(name, password)
            .runOnMainThread()
            .subscribeX(Consumer {
                mvpView?.onPostEnd()
                mvpView?.loginSucess(it)

            }, Consumer {
                mvpView?.onPostEnd()
                HttpErrorHelper.ofMsg(it)
                mvpView?.loginSucess(null)
             //   Log.d("xxxxxxxxxxxxxxx",it.toString())
            })
    }
}