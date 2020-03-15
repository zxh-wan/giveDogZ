package com.zxh.work.pojo

import com.squareup.moshi.Json
import javax.annotation.Generated

@Generated("com.robohorse.robopojogenerator")
data class LoginbeanVo(
    @Json(name = "name")
    var name: String? = null,

    @Json(name = "password")
    var password: String? = null,

    @Json(name = "phone")
    var phone: String? = null,

    @Json(name = "address")
    var address: String? = null,

    @Json(name = "sex")
    var sex: String? = null
)
