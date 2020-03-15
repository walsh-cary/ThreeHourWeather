package com.example.threehourweather.model

class TemperatureConverter {
    companion object{
        fun convertToCelsius(kelvin : Float) = kelvin - 273.15
        fun convertToFahrenheit(kelvin : Float) = Math.round(((kelvin - 273.15) * (1.8) + 32) * 100) / 100
    }
}