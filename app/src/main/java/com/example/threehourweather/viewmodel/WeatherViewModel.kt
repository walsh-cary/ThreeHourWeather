package com.example.threehourweather.viewmodel

import android.content.Context
import android.net.Network
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.threehourweather.model.WeatherNetwork
import com.example.threehourweather.model.WeatherResponse

class WeatherViewModel(val baseUrl: String) : ViewModel() {
    private val currentDataSet: MutableLiveData<WeatherResponse> = MutableLiveData()
    private val forecastDataSet: MutableLiveData<WeatherResponse> = MutableLiveData()

    fun getCurrentDataSet(): LiveData<WeatherResponse> {
        return currentDataSet
    }

    fun getForecastDataSet(): LiveData<WeatherResponse> {
        return forecastDataSet
    }

    fun getCurrentWeatherData(dataSet: WeatherResponse) {
        this.currentDataSet.value = dataSet
    }

    fun getForecastWeatherData(dataSet: WeatherResponse) {
        this.forecastDataSet.value = dataSet
    }

    fun getWeather(context: Context) {
        val network = WeatherNetwork (this)
        network.initRetrofit(baseUrl)
    }
}