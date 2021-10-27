package com.mhl.medit.retrofit

import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MyRetrofit {
    fun getRetrofit() : Retrofit = Retrofit.Builder()
        .baseUrl("http://mskko2021.mad.hakta.pro/api/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
}