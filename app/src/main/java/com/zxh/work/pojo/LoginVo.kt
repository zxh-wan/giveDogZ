package com.zxh.work.pojo

import android.content.ContentValues
import android.database.Cursor
import javax.annotation.Generated
import com.squareup.moshi.Json
import io.reactivex.functions.Function
import top.horsttop.appcore.model.db.Db

@Generated("com.robohorse.robopojogenerator")
data class LoginVo(
    /**
     *
     *
     */
    //"code": "200",
    //"msg": "登录成功",
    //"name": "zxh",
    //        "password": "123456",
    //        "phone": "17763726247",
    //        "address": "杭州",
    //        "sex": "男"

    @Json(name = "code")
    var code: Int?=null,

    @Json(name = "msg")
    var msg: String?=null,

    @Json(name="data")
    val data: LoginbeanVo?=null

   /* @Json(name = "name")
    var name: String? = null,

    @Json(name = "password")
    var password: String? = null,

    @Json(name = "phone")
    var phone: String? = null,

    @Json(name = "address")
    var address: String? = null,

    @Json(name = "sex")
    var sex: String? = null*/

)
