package com.example.weatherapp.features.home.repository

import com.example.weatherapp.data.remote.AppServices
import com.example.weatherapp.data.remote.WeatherForeCast
import com.example.weatherapp.data.remote.response.NetworkResponse

class HomeRepositoryImpl(private val appServices: AppServices) : HomeRepository {

    override suspend fun getWeather(
        city: String,
        apiKey: String
    ): NetworkResponse<WeatherForeCast> {
        // Make the network request using Retrofit
        val response = appServices.getWeather(city, apiKey)
        // Check if the response was successful
        if (response.isSuccessful) {
            // Return the data wrapped in NetworkResponse.Success
            return NetworkResponse.Success(response.body()!!)
        } else {
            // If the response was not successful, return an error
            return NetworkResponse.Error("Error: ${response.message()}", response.code())
        }

    }
}
