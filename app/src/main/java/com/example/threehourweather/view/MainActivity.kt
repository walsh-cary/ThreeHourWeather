package com.example.threehourweather.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.threehourweather.R
import com.example.threehourweather.model.WeatherResponse
import com.example.threehourweather.viewmodel.WeatherViewModel

class MainActivity : AppCompatActivity() {
    private val TAG = "MainActivity"

    var weatherViewModel: WeatherViewModel? = null

    val weatherAdapter: WeatherAdapter by lazy { WeatherAdapter() }

// http://api.openweathermap.org/data/2.5/weather?q=Marietta,ga&APPID=9dddf9e5f4045a5ea94e37a6847e4dc0
// http://api.openweathermap.org/data/2.5/forecast?q=Marietta,ga&APPID=9dddf9e5f4045a5ea94e37a6847e4dc0
// http://api.openweathermap.org/data/2.5/forecast/hourly?q=Marietta,ga&APPID=9dddf9e5f4045a5ea94e37a6847e4dc0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        weatherViewModel = ViewModelProvider(
            this,
            object : ViewModelProvider.Factory {
                override fun <T : ViewModel?> create(modelClass: Class<T>): T {
                    return WeatherViewModel("https://api.openweathermap.org/") as T
                }
            }
        ).get(WeatherViewModel::class.java)

        populateCurrentWeather(weatherViewModel!!)
        weatherViewModel!!.getWeather(this)
    }

    private fun populateCurrentWeather(weatherViewModel: WeatherViewModel) {
        Log.d(TAG, "popuateRockMusic() executed")
        weatherViewModel.getCurrentDataSet().observe(
            this@MainActivity,
            object : Observer<WeatherResponse> {
                override fun onChanged(t: WeatherResponse?) {
                    weatherAdapter.dataSet = t
                }
            })
    }
}
