package com.example.weatherapp.data.remote.model.fivedaysweatherdata


import com.google.gson.annotations.SerializedName

data class Wind(
    @SerializedName("deg")
    var deg: Int? = null,
    @SerializedName("gust")
    var gust: Double? = null,
    @SerializedName("speed")
    var speed: Double? = null
)