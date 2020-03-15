package com.example.threehourweather.view

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.threehourweather.R
import com.example.threehourweather.model.ListResponse

class WeatherViewHolder (itemView: View)
    : RecyclerView.ViewHolder(itemView) {
    val forecastTemp: TextView = itemView.findViewById(R.id.tv_forecast_temperature)
    val weatherIcon: ImageView = itemView.findViewById(R.id.iv_forecast_weather_icon)
    val forecastTime: TextView = itemView.findViewById(R.id.tv_forecast_time)

    fun onBind(item: ListResponse) {
        forecastTemp.text = (item.main.temp.toString() + "°")
        Glide.with(itemView).load("http://openweathermap.org/img/wn/" + item.weather[position].icon + "@2x.png")
            .into(weatherIcon)
    }
}