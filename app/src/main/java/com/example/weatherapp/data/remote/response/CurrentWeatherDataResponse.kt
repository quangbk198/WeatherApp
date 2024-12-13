package com.example.weatherapp.data.remote.response


import com.example.weatherapp.data.remote.model.currentweatherdata.Clouds
import com.example.weatherapp.data.remote.model.currentweatherdata.Coord
import com.example.weatherapp.data.remote.model.currentweatherdata.Main
import com.example.weatherapp.data.remote.model.currentweatherdata.Rain
import com.example.weatherapp.data.remote.model.currentweatherdata.Sys
import com.example.weatherapp.data.remote.model.currentweatherdata.Weather
import com.example.weatherapp.data.remote.model.currentweatherdata.Wind
import com.google.gson.annotations.SerializedName

data class CurrentWeatherDataResponse(
    @SerializedName("base")
    var base: String? = null,
    @SerializedName("clouds")
    var clouds: Clouds? = null,
    @SerializedName("cod")
    var cod: Int? = null,
    @SerializedName("coord")
    var coord: Coord? = null,
    @SerializedName("dt")
    var dt: Int? = null,
    @SerializedName("id")
    var id: Int? = null,
    @SerializedName("main")
    var main: Main? = null,
    @SerializedName("name")
    var name: String? = null,
    @SerializedName("rain")
    var rain: Rain? = null,
    @SerializedName("sys")
    var sys: Sys? = null,
    @SerializedName("timezone")
    var timezone: Int? = null,
    @SerializedName("visibility")
    var visibility: Int? = null,
    @SerializedName("weather")
    var weather: List<Weather?>? = null,
    @SerializedName("wind")
    var wind: Wind? = null
)