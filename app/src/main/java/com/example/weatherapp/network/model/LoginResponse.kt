package com.example.weatherapp.network.model


import com.google.gson.annotations.SerializedName

data class LoginResponse(
    @SerializedName("id")
    val id: Int,
    @SerializedName("jwtToken")
    val jwtToken: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("refreshToken")
    val refreshToken: String,
    @SerializedName("surname")
    val surname: String,
    @SerializedName("username")
    val username: String
)