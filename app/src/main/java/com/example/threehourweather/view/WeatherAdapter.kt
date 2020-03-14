package com.example.threehourweather.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.threehourweather.R
import com.example.threehourweather.model.WeatherResponse

class WeatherAdapter : RecyclerView.Adapter<WeatherViewHolder>() {
    var dataSet: WeatherResponse? = null
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WeatherViewHolder =
        WeatherViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(
                    R.layout.weather_card_view,
                    parent,
                    false
                )
        )

    override fun getItemCount(): Int {
        return dataSet?.weather?.size ?: 0
    }

    override fun onBindViewHolder(holder: WeatherViewHolder, position: Int) {
        dataSet?.let {
            holder.onBind(it)
        }
    }
}