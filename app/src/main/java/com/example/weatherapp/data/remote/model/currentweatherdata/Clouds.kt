package com.example.weatherapp.data.remote.model.currentweatherdata


import com.google.gson.annotations.SerializedName

data class Clouds(
    @SerializedName("all")
    var all: Int? = null
)