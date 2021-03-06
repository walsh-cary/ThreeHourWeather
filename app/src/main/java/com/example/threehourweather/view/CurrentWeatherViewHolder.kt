package com.example.threehourweather.view

import android.view.View
import android.widget.TextView
import com.example.threehourweather.R
import com.example.threehourweather.model.CurrentWeatherResponse
import com.example.threehourweather.model.TemperatureConverter

class CurrentWeatherViewHolder(val itemView: View) {
    val city: TextView = itemView.findViewById(R.id.tv_city)
    val currentTemp: TextView = itemView.findViewById(R.id.tv_current_temperature)
    val currentWeather: TextView = itemView.findViewById(R.id.tv_current_weather)

    fun onBind(item: CurrentWeatherResponse) {
        val cTemp = TemperatureConverter.convertToFahrenheit(item.main.temp)
        city.text = item.name
        currentTemp.text = ("$cTemp°")
        currentWeather.text = item.weather[0].main
    }
}