package com.example.weatherapp.features.home

import androidx.lifecycle.MutableLiveData
import com.example.weatherapp.core.base.viewmodel.BaseViewModel
import com.example.weatherapp.data.remote.response.CurrentWeatherDataResponse
import com.example.weatherapp.data.remote.response.FiveDaysWeatherDataResponse
import com.example.weatherapp.utils.RepositoryFactory
import kotlinx.coroutines.launch

class HomeViewModel: BaseViewModel() {

    val currentWeatherResponseData = MutableLiveData<CurrentWeatherDataResponse>()
    val fivedaysWeatherResponseData = MutableLiveData<FiveDaysWeatherDataResponse>()

    fun getCurrentWeatherData() {
        coroutineScope.launch {
            setLoading(true)
            val response = RepositoryFactory.getHomeRepository()
                .getCurrentWeatherData(16.00, 106.00)

            currentWeatherResponseData.value = response
            setLoading(false)
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


}
