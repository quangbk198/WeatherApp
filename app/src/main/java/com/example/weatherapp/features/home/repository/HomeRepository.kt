package com.example.weatherapp.features.home.repository

import com.example.weatherapp.data.remote.WeatherForeCast
import com.example.weatherapp.data.remote.response.NetworkResponse


interface HomeRepository {
    suspend fun getWeather(city: String, apiKey: String): NetworkResponse<WeatherForeCast>
}
