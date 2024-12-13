package com.example.weatherapp.data.remote.model.fivedaysweatherdata


import com.google.gson.annotations.SerializedName

data class Rain(
    @SerializedName("3h")
    var h: Double? = null
)