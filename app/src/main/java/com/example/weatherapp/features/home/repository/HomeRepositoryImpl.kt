package com.example.weatherapp.features.home.repository

import android.annotation.SuppressLint
import com.example.weatherapp.data.remote.AppServices
import com.example.weatherapp.data.remote.RetrofitInstance
import com.example.weatherapp.data.remote.model.currentweatherdata.Coord
import com.example.weatherapp.data.remote.response.CurrentWeatherDataResponse
import com.example.weatherapp.data.remote.response.FiveDaysWeatherDataResponse
import com.google.android.gms.location.FusedLocationProviderClient
import kotlinx.coroutines.suspendCancellableCoroutine
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException

class HomeRepositoryImpl : HomeRepository {

    override suspend fun getCurrentWeatherData(lat: Double, lon: Double): CurrentWeatherDataResponse {
        return RetrofitInstance.weatherApi.getWeather(lat, lon)
    }

//    override suspend fun getFiveDaysWeatherData(
//        lat: Double, lon: Double
//    ): FiveDaysWeatherDataResponse {
//        return RetrofitInstance.weatherApi.getFiveDaysWeather(lat, lon)
//    }

    @SuppressLint("MissingPermission")
    override suspend fun getCurrentLocation(fusedLocationClient: FusedLocationProviderClient): Coord {
        return suspendCancellableCoroutine { continuation ->
            fusedLocationClient.lastLocation.addOnSuccessListener { location ->
                continuation.resume(Coord(location.latitude, location.longitude))
            }.addOnFailureListener { exception ->
                continuation.resumeWithException(exception)
            }
        }
    }

}
