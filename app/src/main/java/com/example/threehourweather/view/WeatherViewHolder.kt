package com.example.threehourweather.view

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.threehourweather.R
import com.example.threehourweather.model.WeatherResponse
import java.lang.StringBuilder

class WeatherViewHolder (itemView: View)
    : RecyclerView.ViewHolder(itemView) {
    val city: TextView = itemView.findViewById(R.id.tv_city)
    val currentTemp: TextView = itemView.findViewById(R.id.tv_current_temperature)
    val forecastTemp: TextView = itemView.findViewById(R.id.tv_forecast_temperature)
    val weatherIcon: ImageView = itemView.findViewById(R.id.iv_forecast_weather_icon)
    val currentWeather: TextView = itemView.findViewById(R.id.tv_current_weather)
    val forecastTime: TextView = itemView.findViewById(R.id.tv_forecast_time)

    fun onBind(item: WeatherResponse) {
        city.text = item.city[0].name
        currentTemp.text = item.list[0].main[0].temp.toString()
        forecastTemp.text = item.list[0].main[0].temp.toString()
        Glide.with(itemView)
            .load(StringBuilder("http://openweathermap.org/img/wn/" + item.weather[0].icon + "@2x.png"))
            .into(weatherIcon)
        currentWeather.text = item.weather[0].main
    }
}