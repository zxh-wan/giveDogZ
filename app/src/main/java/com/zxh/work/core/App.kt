package com.zxh.work.core

import android.app.Activity
import android.content.Intent

import com.zxh.work.di.component.AppComponent
import com.zxh.work.di.component.DaggerAppComponent
import com.zxh.work.pojo.RegisterbeanVo
import com.zxh.work.ui.activity.MainActivity
import timber.log.Timber
import top.horsttop.appcore.core.GenApp
import top.horsttop.appcore.load.callback.EmptyCallback
import top.horsttop.appcore.load.callback.ErrorCallback
import top.horsttop.appcore.load.callback.LoadingCallback
import top.horsttop.appcore.load.callback.TimeoutCallback
import top.horsttop.appcore.load.core.Loader

/**
 * Created by horsttop on 2018/4/13.
 */
class App : GenApp() {


    override fun onCreate() {
        super.onCreate()





        appComponent = DaggerAppComponent.builder()
            .coreComponent(coreComponent)
            .build()
        appComponent.inject(this)


    }

    override fun initLoader() {
        Loader.beginBuilder()
            .addCallback(ErrorCallback())
            .addCallback(EmptyCallback())
            .addCallback(LoadingCallback())
            .addCallback(TimeoutCallback())

            .setDefaultCallback(LoadingCallback::class.java)
            .commit()
    }


    companion object {

        @JvmStatic
        lateinit var appComponent: AppComponent


        var sUid: Long = 0

        var list: ArrayList<RegisterbeanVo?> ?= ArrayList()

        var sPhone: String? = null

        var sCodeTimeStamp = 0L

        fun isLogin(activity: Activity): Boolean {
            return if (App.sUid > 0)
                true
            else {
                activity.startActivity(Intent(activity, MainActivity::class.java))
                false
            }
        }
    }

}