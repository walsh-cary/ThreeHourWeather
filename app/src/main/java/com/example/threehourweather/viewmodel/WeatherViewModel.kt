package com.example.threehourweather.viewmodel

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.threehourweather.model.CurrentWeatherResponse
import com.example.threehourweather.model.ForecastWeatherResponse
import com.example.threehourweather.model.WeatherNetwork

class WeatherViewModel(val baseUrl: String) : ViewModel() {
    private val currentDataSet: MutableLiveData<CurrentWeatherResponse> = MutableLiveData()
    private val forecastDataSet: MutableLiveData<ForecastWeatherResponse> = MutableLiveData()

    fun getCurrentDataSet(): LiveData<CurrentWeatherResponse> {
        return currentDataSet
    }

    fun getForecastDataSet(): LiveData<ForecastWeatherResponse> {
        return forecastDataSet
    }

    fun getCurrentWeatherData(dataSet: CurrentWeatherResponse) {
        this.currentDataSet.value = dataSet
    }

    fun getForecastWeatherData(dataSet: ForecastWeatherResponse) {
        this.forecastDataSet.value = dataSet
    }

    fun getWeather(context: Context) {
        val network = WeatherNetwork (this)
        network.initRetrofit(baseUrl)
    }
}