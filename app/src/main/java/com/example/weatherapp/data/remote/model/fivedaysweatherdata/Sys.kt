package com.example.weatherapp.data.remote.model.fivedaysweatherdata


import com.google.gson.annotations.SerializedName

data class Sys(
    @SerializedName("pod")
    var pod: String? = null
)