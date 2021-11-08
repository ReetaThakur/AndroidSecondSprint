package com.example.androidsecondsprint.apiCall

import com.example.androidsecondsprint.response.ResponseDTO
import io.reactivex.rxjava3.core.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiCall {

    @GET("top-headlines")
    fun getInstance(@Query("country") country:String,
    @Query("apiKey") apikey:String):Observable<ResponseDTO>
}