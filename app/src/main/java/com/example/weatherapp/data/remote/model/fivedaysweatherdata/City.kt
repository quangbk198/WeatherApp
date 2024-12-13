package com.example.weatherapp.data.remote.model.fivedaysweatherdata


import com.google.gson.annotations.SerializedName

data class City(
    @SerializedName("coord")
    var coord: Coord? = null,
    @SerializedName("country")
    var country: String? = null,
    @SerializedName("id")
    var id: Int? = null,
    @SerializedName("name")
    var name: String? = null,
    @SerializedName("population")
    var population: Int? = null,
    @SerializedName("sunrise")
    var sunrise: Int? = null,
    @SerializedName("sunset")
    var sunset: Int? = null,
    @SerializedName("timezone")
    var timezone: Int? = null
)