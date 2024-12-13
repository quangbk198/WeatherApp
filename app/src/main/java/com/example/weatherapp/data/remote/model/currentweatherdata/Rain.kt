package com.example.weatherapp.data.remote.model.currentweatherdata


import com.google.gson.annotations.SerializedName

data class Rain(
    @SerializedName("1h")
    var h: Double? = null
)