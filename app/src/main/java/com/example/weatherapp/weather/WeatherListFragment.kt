package com.example.weatherapp.weather

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.weatherapp.R
import com.example.weatherapp.databinding.FragmentWeatherListBinding
import com.example.weatherapp.network.RetrofitClient
import com.example.weatherapp.network.WeatherApiService
import com.example.weatherapp.network.model.LoginResponse
import com.example.weatherapp.network.model.RefreshRequest
import com.example.weatherapp.network.model.WeatherResponse
import com.example.weatherapp.weather.adapter.WeatherListAdapter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class WeatherListFragment : Fragment() {
    private lateinit var binding: FragmentWeatherListBinding
    val refreshToken=RefreshRequest()
    var token:String=""
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_weather_list, container, false
        )
        requestToTheService()
        requestRefreshService()
        return binding.root
    }

    fun requestToTheService() {
        val data = arguments?.getString("jwtToken").toString()

        RetrofitClient.getClient().create(WeatherApiService::class.java)
            .getWeatherResponse("Bearer " + data).enqueue(object :
            Callback<WeatherResponse> {
            override fun onFailure(call: Call<WeatherResponse>, t: Throwable) {
                Log.v("onFail", "${t.message}")
            }
            override fun onResponse(
                call: Call<WeatherResponse>,
                response: Response<WeatherResponse>
            ) {
                val weatherList = response.body()
                binding.recyclerView.layoutManager = LinearLayoutManager(activity)
                binding.recyclerView.adapter =
                    weatherList?.let { WeatherListAdapter(it) }
            }
        })
    }


    fun requestRefreshService()
    {
        refreshToken.refreshToken=arguments?.getString("refreshToken").toString()
        token= refreshToken.toString()
        RetrofitClient.getClient().create(WeatherApiService::class.java)
            .getRefreshToken(refreshToken).enqueue(object :
                Callback<LoginResponse> {
                override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                    Log.v("onFail", "${t.message}")
                }
                override fun onResponse(
                    call: Call<LoginResponse>,
                    response: Response<LoginResponse>
                ) {
                    Log.v("onSuccess", response.message())
                }

            })


    }
}



