package com.example.weatherapp.features.home.repository

import com.example.weatherapp.data.remote.response.CurrentWeatherDataResponse
import com.example.weatherapp.data.remote.response.FiveDaysWeatherDataResponse


interface HomeRepository {

    suspend fun getCurrentWeatherData(lat: Double, lon: Double): CurrentWeatherDataResponse
    suspend fun getFiveDaysWeatherData( lat: Double, lon: Double): FiveDaysWeatherDataResponse
}
