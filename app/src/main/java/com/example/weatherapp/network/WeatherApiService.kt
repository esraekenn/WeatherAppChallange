package com.example.weatherapp.network

import com.example.weatherapp.network.model.LoginRequest
import com.example.weatherapp.network.model.LoginResponse
import com.example.weatherapp.network.model.RefreshRequest
import com.example.weatherapp.network.model.WeatherResponse
import retrofit2.Call
import retrofit2.http.*

interface WeatherApiService
{
    @POST("api/user/authenticate")
    fun getMovieResponse(
       @Body loginRequest:LoginRequest
    ): Call<LoginResponse>

    @GET("weatherforecast")
    fun getWeatherResponse(
        @Header("Authorization") jwt: String
    ):Call<WeatherResponse>

    @POST("api/user/refresh-token")
    fun getRefreshToken(
        @Body refreshToken: RefreshRequest
    ):Call<LoginResponse>
}