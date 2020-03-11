package com.example.threehourweather.model

data class WeatherResponse (
    var city : List<CityPoko>,
    var list : List<ListResponse>
)

data class CityPoko (
    var name : String
)

data class ListResponse (
    var main : List<MainPoko>,
    var clouds : List<CloudsPoko>,
    var dt_text : String            // date and time "YYYY-MM-DD HH:MM:SS"
)

data class MainPoko (
    var temp : Float                // in Kelvin
)

data class CloudsPoko (
    var all : Float                 // cloudiness percentage
)