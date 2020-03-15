package com.zxh.work.model.api


import com.zxh.work.pojo.*
import io.reactivex.Flowable
import retrofit2.http.*

/**
 * Created by horsttop on 2018/4/19.
 */
interface HttpApi {



    //登录
    // http://mock-api.com/mnE6PEKJ.mock/login
    @GET("mnE6PEKJ.mock/login")
    fun Login(
        @Query("name") name: String,
        @Query("password") password: String
    ): Flowable<LoginVo>


    //注册
    @GET("mnE6PEKJ.mock/register")
    fun Register(
        @Query("name") name: String,
        @Query("password") password: String
    ): Flowable<RegisterVo>


}