package com.example.threehourweather.model

import com.example.threehourweather.viewmodel.WeatherViewModel
import okhttp3.OkHttpClient

class WeatherNetwork (val viewModel : WeatherViewModel) {
    fun initRetrofit(baseUrl : String, okHttpClient: OkHttpClient) {
        //todo call each api
    }
}