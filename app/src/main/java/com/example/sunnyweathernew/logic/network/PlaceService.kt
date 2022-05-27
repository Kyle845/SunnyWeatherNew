package com.example.sunnyweathernew.logic.network

import com.example.sunnyweathernew.SunnyWeatherApplication
import com.example.sunnyweathernew.logic.model.PlaceResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface PlaceService {
  @GET("v2/place?token=${SunnyWeatherApplication.TOKEN}&lang=zh_CN")
  fun searchPlaces(@Query("query") query: String):retrofit2.Call<PlaceResponse>
}