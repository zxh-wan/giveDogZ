package com.zxh.work.model.http

import android.util.Log
import retrofit2.HttpException
import top.horsttop.appcore.core.GenApp
import top.horsttop.appcore.util.toast.ToastUtil
import java.io.IOException

/**
 * Created by horsttop on 11.October.2018
 */
object HttpErrorHelper{


    fun ofMsg(throwable:Throwable){


        if (throwable is HttpException) {
            try {
                val json = throwable.response().errorBody()!!.string()
                Log.d("xxxxxx",json.toString())
             //   var error = GenApp.moshi.adapter(DataErrorVo::class.java).fromJson(json)
             //   ToastUtil.showShort(error!!.msg)
//                return AppService.getGson().fromJson(json, ResponseData::class.java)
            } catch (e: IOException) {

            }

        }
//        else if (throwable is ProtocolException) {
//            val msg = ResponseData()
//            msg.setCode(401)
//            AppService.getPreferencesHelper().saveConfig("uid", 0)
//            //HttpFactory.sHttpClient.authToken(Constants.DEFAULT_TOKEN);
//            msg.setMsg("您的账号在另外的终端登录")
//            return msg
//        }
    }
}