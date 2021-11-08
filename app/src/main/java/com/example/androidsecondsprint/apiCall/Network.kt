package com.example.androidsecondsprint.apiCall

import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

object Network {

    val BASE_URL="https://newsapi.org/v2/"

    fun getRetrofit()=Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
        .build()

    fun getApiService() = getRetrofit().create(ApiCall::class.java)
}