package com.example.threehourweather.model

data class ForecastWeatherResponse (
    var list: List<ListResponse>
)

data class ListResponse (
    var main: MainResponse,
    var weather: List<WeatherResponse>,
    var dt_text: String             // YYYY-MM-DD HH:MM:SS
)

data class MainResponse (
    var temp: Float = 0f
)

data class WeatherResponse (
    var main: String,
    var icon: String
)