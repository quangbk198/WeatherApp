package com.example.weatherapp.data.remote.model.fivedaysweatherdata


import com.google.gson.annotations.SerializedName

data class Snow(
    @SerializedName("3h")
    var h: Double? = null
)