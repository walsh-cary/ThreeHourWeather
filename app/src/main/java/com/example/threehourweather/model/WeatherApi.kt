package com.example.threehourweather.model

import retrofit2.Call
import retrofit2.http.GET

interface WeatherApi {
    @GET("data/2.5/forecast?q=Marietta&APPID=9dddf9e5f4045a5ea94e37a6847e4dc0")
    fun getWeather() : Call<WeatherResponse>
}