package com.example.weatherapp.data.remote

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface AppServices {
    @GET("data/2.5/weather")
    suspend fun getWeather(
        @Query("q") city: String,
        @Query("appid") apiKey: String
    ): Response<WeatherForeCast>  //  data class name
}
