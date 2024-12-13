package com.example.weatherapp.data.remote

import com.example.weatherapp.data.remote.response.CurrentWeatherDataResponse
import com.example.weatherapp.data.remote.response.FiveDaysWeatherDataResponse
import com.example.weatherapp.utils.Constants
import retrofit2.http.GET
import retrofit2.http.Query

interface AppServices {
    // Get current weather by latitude and longitude
    @GET("data/2.5/weather")
    suspend fun getWeather(
        @Query("lat") lat: Double,
        @Query("lon") lon: Double,
        @Query("appid") appid: String = Constants.WEATHER_API_KEY,
    ): CurrentWeatherDataResponse  //  data class name

    // Get 5-day weather forecast by latitude and longitude
    @GET("data/2.5/weather/forecast")
    suspend fun getFiveDaysWeather(
        @Query("lat") lat: Double,
        @Query("lon") lon: Double,
        @Query("appid") appid: String = Constants.WEATHER_API_KEY,
    ): FiveDaysWeatherDataResponse  //  data class name
}
