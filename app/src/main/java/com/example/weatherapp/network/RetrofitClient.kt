package com.example.weatherapp.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitClient {
    companion object {
        fun getClient(): Retrofit {
            return Retrofit.Builder()
                .baseUrl("https://testcase1.keove.com/")
                .addConverterFactory(GsonConverterFactory.create()).build()
        }
    }

}
