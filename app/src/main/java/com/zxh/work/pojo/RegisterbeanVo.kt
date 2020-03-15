package com.zxh.work.pojo

import com.squareup.moshi.Json
import javax.annotation.Generated

@Generated("com.robohorse.robopojogenerator")
data class RegisterbeanVo(

    @Json(name = "name")
    var name: String? = null,

    @Json(name = "password")
    var password: String? = null
)