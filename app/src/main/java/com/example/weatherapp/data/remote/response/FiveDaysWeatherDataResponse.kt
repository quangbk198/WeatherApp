package com.example.weatherapp.data.remote.response


import com.example.weatherapp.data.remote.model.fivedaysweatherdata.City
import com.example.weatherapp.data.remote.model.fivedaysweatherdata.Item8
import com.google.gson.annotations.SerializedName

data class FiveDaysWeatherDataResponse(
    @SerializedName("city")
    var city: City? = null,
    @SerializedName("cnt")
    var cnt: Int? = null,
    @SerializedName("cod")
    var cod: String? = null,
    @SerializedName("list")
    var list: List<Item8?>? = null,
    @SerializedName("message")
    var message: Int? = null
)