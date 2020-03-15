package com.example.threehourweather.model

data class ForecastWeatherResponse (
    var list: List<ListResponse>
)

data class ListResponse (
    var main: MainResponse,
    var weather: WeatherResponse,
    var dt_text: String             // YYYY-MM-DD HH:MM:SS
)

data class MainResponse (
    var temp: Float = 0.00f
)

data class WeatherResponse (
    var main: String,
    var icon: String
)