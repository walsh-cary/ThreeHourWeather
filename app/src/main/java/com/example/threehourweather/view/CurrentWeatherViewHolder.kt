package com.example.threehourweather.view

import android.view.View
import android.widget.TextView
import com.example.threehourweather.R
import com.example.threehourweather.model.CurrentWeatherResponse

class CurrentWeatherViewHolder(val itemView: View) {
    val city: TextView = itemView.findViewById(R.id.tv_city)
    val currentTemp: TextView = itemView.findViewById(R.id.tv_current_temperature)
    val currentWeather: TextView = itemView.findViewById(R.id.tv_current_weather)

    fun onBind(item: CurrentWeatherResponse) {
        city.text = item.name
        currentTemp.text = (item.main.temp.toString() + "°")
        currentWeather.text = item.weather[0].main
    }
}