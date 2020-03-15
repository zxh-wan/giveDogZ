package com.zxh.work.di.component


import com.zxh.work.di.module.ApiModule
import com.zxh.work.di.module.DBModule
import com.zxh.work.model.api.HttpApi
import com.squareup.sqlbrite3.BriteDatabase
import com.zxh.work.core.App
import dagger.Component
import top.horsttop.appcore.dagger.component.CoreComponent
import top.horsttop.appcore.dagger.runtime.PerApplication
import javax.inject.Singleton

/**
 * Created by horsttop on 2018/4/23.
 */
@PerApplication
@Component(dependencies = arrayOf(CoreComponent::class),modules = arrayOf(ApiModule::class, DBModule::class))
interface AppComponent {

    fun httpApi(): HttpApi


    fun database(): BriteDatabase
    fun inject(app: App)

}