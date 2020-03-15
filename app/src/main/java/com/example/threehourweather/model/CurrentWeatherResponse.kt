package com.example.threehourweather.model

data class CurrentWeatherResponse (
    var weather : List<WeatherPoko>,
    var name: String,
    var main : MainPoko
)

data class WeatherPoko (
    var main : String
)

data class MainPoko (
    var temp : Float = 0f             // in Kelvin
)