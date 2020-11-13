package com.example.weatherapp.weather.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.weatherapp.R
import com.example.weatherapp.dateDoDay
import com.example.weatherapp.network.model.Weather

class WeatherListViewHolder(container: ViewGroup) : RecyclerView.ViewHolder(
    LayoutInflater.from(container.context).inflate
        (
        R.layout.row_weather_item, container, false
    )
) {
    val weatherDate: TextView = itemView.findViewById(R.id.txtDate)
    val weatherFah: TextView = itemView.findViewById(R.id.txtFah)
    val weatherCel: TextView = itemView.findViewById(R.id.txtCel)
    val weatherSum: TextView = itemView.findViewById(R.id.txtSum)

    fun bind(weather: Weather) {
        weatherDate.text = weather.date.dateDoDay()
        weatherFah.text = "Fahrenhit: " + weather.temperatureF.toString()
        weatherCel.text = "Celsius: " + weather.temperatureC.toString()
        weatherSum.text = "Summary: " + weather.summary


    }
}