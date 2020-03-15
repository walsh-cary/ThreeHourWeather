package com.example.threehourweather.model

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApi {
    // data/2.5/weather?zip={ZIP}&APPID=9dddf9e5f4045a5ea94e37a6847e4dc0

    @GET("data/2.5/weather")
    fun getCurrentWeather(@Query("zip") zip: String, @Query("APPID") api: String) : Call<CurrentWeatherResponse>

    @GET()
    fun getForecastWeather() : Call<ForecastWeatherResponse>
}