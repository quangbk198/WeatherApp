package com.example.weatherapp.features.home

import androidx.lifecycle.MutableLiveData
import com.example.weatherapp.core.base.viewmodel.BaseViewModel
import com.example.weatherapp.data.remote.model.currentweatherdata.Coord
import com.example.weatherapp.data.remote.response.CurrentWeatherDataResponse
import com.example.weatherapp.data.remote.response.FiveDaysWeatherDataResponse
import com.example.weatherapp.utils.RepositoryFactory
import com.google.android.gms.location.FusedLocationProviderClient
import kotlinx.coroutines.launch

class HomeViewModel: BaseViewModel() {

    val currentWeatherResponseData = MutableLiveData<CurrentWeatherDataResponse>()
    val fivedaysWeatherResponseData = MutableLiveData<FiveDaysWeatherDataResponse>()
    val currentCoord = MutableLiveData<Coord>()


//    fun getCurrentWeatherData(lat: Double, lon: Double) {
//        coroutineScope.launch {
//            setLoading(true)
//            val response = RepositoryFactory.getHomeRepository()
//                .getCurrentWeatherData()
//
//            currentWeatherResponseData.value = response
//            setLoading(false)
//        }
//    }
    fun fetchCurrentWeather(fusedLocationClient: FusedLocationProviderClient) {
        coroutineScope.launch {
            setLoading(true)
                // Get lat and lon current location
                val coord = RepositoryFactory.getHomeRepository().getCurrentLocation(fusedLocationClient)

                // check `lat` và `lon`
                val lat = coord.lat ?: throw IllegalArgumentException("Latitude is null")
                val lon = coord.lon ?: throw IllegalArgumentException("Longitude is null")

                // Get lat lon to call API
                val weatherData = RepositoryFactory.getHomeRepository().getCurrentWeatherData(lat, lon)

                // Update data to livedata
                currentWeatherResponseData.value = weatherData

                setLoading(false)
            }
        }
    }

//    fun getFiveDaysWeatherData() {
//        coroutineScope.launch {
//            setLoading(true)
//            val response = RepositoryFactory.getHomeRepository()
//                .getFiveDaysWeatherData(0.0,0.0)
//
//            fivedaysWeatherResponseData.value = response
//            setLoading(false)
//        }
//    }



