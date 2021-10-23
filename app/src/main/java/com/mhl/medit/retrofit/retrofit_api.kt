package com.mhl.medit.retrofit

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface retrofit_api{
    @POST("user/login")
    fun getAuth(@Body hashMap: HashMap<String, String>):Call<login>
    @GET("/quotes")
    fun getQuotes():Call<quotes>
    @GET("/feelings")
    fun getFeelings():Call<feelings>
}