package com.example.threehourweather.view

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.Window
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.threehourweather.R
import com.example.threehourweather.model.CurrentWeatherResponse
import com.example.threehourweather.model.ForecastWeatherResponse
import com.example.threehourweather.viewmodel.WeatherViewModel

class MainActivity : AppCompatActivity() {
    private val TAG = "MainActivity"

    var weatherViewModel: WeatherViewModel? = null

    val forecastWeatherAdapter: ForecastWeatherAdapter by lazy { ForecastWeatherAdapter() }

    var currentViewHolder: CurrentWeatherViewHolder? = null

// http://api.openweathermap.org/data/2.5/weather?q=Marietta,ga&APPID=9dddf9e5f4045a5ea94e37a6847e4dc0
// http://api.openweathermap.org/data/2.5/forecast?q=Marietta,ga&APPID=9dddf9e5f4045a5ea94e37a6847e4dc0
// http://api.openweathermap.org/data/2.5/forecast/hourly?q=Marietta,ga&APPID=9dddf9e5f4045a5ea94e37a6847e4dc0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        requestWindowFeature(Window.FEATURE_NO_TITLE)
        getSupportActionBar()!!.hide()

        setContentView(R.layout.activity_main)

        val settingsButton: ImageButton = findViewById(R.id.btn_settings)

        currentViewHolder = CurrentWeatherViewHolder(findViewById(R.id.top_bar))

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

        val intent = Intent(this, PreferencesActivity::class.java)

        settingsButton.setOnClickListener { v -> startActivity(intent)}
    }

    private fun populateForecastWeather(weatherViewModel: WeatherViewModel) {
        Log.d(TAG, "populateForecastWeather() executed")
        weatherViewModel.getForecastDataSet().observe(
            this@MainActivity,
            object : Observer<ForecastWeatherResponse> {
                override fun onChanged(t: ForecastWeatherResponse?) {
                    forecastWeatherAdapter.dataSet = t
                }
            })
    }

    private fun populateCurrentWeather(weatherViewModel: WeatherViewModel) {
        Log.d(TAG, "populateCurrentWeather() executed")
        weatherViewModel.getCurrentDataSet().observe(
            this,
            object : Observer<CurrentWeatherResponse> {
                override fun onChanged(t: CurrentWeatherResponse?) {
                    currentViewHolder!!.onBind(t!!)
                }
            }
        )
    }
}
