package com.example.weatherapp.data.remote.model.fivedaysweatherdata


import com.google.gson.annotations.SerializedName

data class Item8(
    @SerializedName("clouds")
    var clouds: Clouds? = null,
    @SerializedName("dt")
    var dt: Int? = null,
    @SerializedName("dt_txt")
    var dtTxt: String? = null,
    @SerializedName("main")
    var main: Main? = null,
    @SerializedName("pop")
    var pop: Double? = null,
    @SerializedName("rain")
    var rain: Rain? = null,
    @SerializedName("snow")
    var snow: Snow? = null,
    @SerializedName("sys")
    var sys: Sys? = null,
    @SerializedName("visibility")
    var visibility: Int? = null,
    @SerializedName("weather")
    var weather: List<Weather?>? = null,
    @SerializedName("wind")
    var wind: Wind? = null
)