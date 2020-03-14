package com.example.threehourweather.model

data class WeatherResponse (
    var weather : List<WeatherPoko>,
    var city : List<CityPoko>,
    var list : List<ListResponse>
)

data class WeatherPoko (
    var main : String,
    var icon : String
)

data class CityPoko (
    var name : String
)

data class ListResponse (
    var main : List<MainPoko>,
    var dt_text : String            // date and time "YYYY-MM-DD HH:MM:SS"
)

data class MainPoko (
    var temp : Float                // in Kelvin
)