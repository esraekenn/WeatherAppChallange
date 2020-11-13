package com.example.weatherapp.weather.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.weatherapp.network.model.Weather

class WeatherListAdapter(
    val weatherList: List<Weather>
) : RecyclerView.Adapter<WeatherListViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WeatherListViewHolder {
        return WeatherListViewHolder(parent)
    }

    override fun onBindViewHolder(holderList: WeatherListViewHolder, position: Int) {
        holderList.bind(weatherList[position])
    }

    override fun getItemCount(): Int {
        return weatherList.size
    }
}
