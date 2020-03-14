package com.example.threehourweather.model

import retrofit2.Call
import retrofit2.http.GET

interface WeatherApi {
    //todo figure out how to hide api keys
    @GET()
    fun getCurrentWeather() : Call<WeatherResponse>

    @GET()
    fun getForecastWeather() : Call<WeatherResponse>
}