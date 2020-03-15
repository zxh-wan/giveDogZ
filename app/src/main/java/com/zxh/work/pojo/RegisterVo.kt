package com.zxh.work.pojo

import com.squareup.moshi.Json
import javax.annotation.Generated

@Generated("com.robohorse.robopojogenerator")
data class RegisterVo(
    @Json(name = "code")
    var code: Int? = null,
    @Json(name = "msg")
    var msg: String? = null,
    @Json(name = "data")
    var data: RegisterbeanVo? = null
)

