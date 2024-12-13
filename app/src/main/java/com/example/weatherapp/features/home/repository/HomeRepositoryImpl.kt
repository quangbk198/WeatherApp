package com.example.weatherapp.features.home.repository

import com.example.weatherapp.data.remote.AppServices
import com.example.weatherapp.data.remote.RetrofitInstance
import com.example.weatherapp.data.remote.response.CurrentWeatherDataResponse
import com.example.weatherapp.data.remote.response.FiveDaysWeatherDataResponse

class HomeRepositoryImpl : HomeRepository {

    override suspend fun getCurrentWeatherData(lat: Double, lon: Double): CurrentWeatherDataResponse {
        return RetrofitInstance.weatherApi.getWeather(lat, lon)
    }

    override suspend fun getFiveDaysWeatherData(
        lat: Double, lon: Double
    ): FiveDaysWeatherDataResponse {
        return RetrofitInstance.weatherApi.getFiveDaysWeather(lat, lon)
    }


}
