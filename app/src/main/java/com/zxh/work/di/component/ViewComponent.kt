package com.zxh.work.di.component


import com.zxh.work.core.App

import com.zxh.work.ui.activity.MainActivity
import com.zxh.work.ui.activity.RegisterActivity


import dagger.Component
import top.horsttop.appcore.dagger.runtime.PerView

/**
 * Created by horsttop on 2018/4/23.
 */
@PerView
@Component(dependencies = arrayOf(AppComponent::class))
interface ViewComponent {

    fun inject(view : MainActivity)

    fun inject(view : RegisterActivity)
  //  fun inject(view : IndexFragment)






}