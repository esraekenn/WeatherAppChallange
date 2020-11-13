package com.example.weatherapp.network.model


import com.google.gson.annotations.SerializedName

data class Weather(
    @SerializedName("date")
    val date: String,
    @SerializedName("summary")
    val summary: String,
    @SerializedName("temperatureC")
    val temperatureC: Int,
    @SerializedName("temperatureF")
    val temperatureF: Int
)