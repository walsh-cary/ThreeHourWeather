package com.example.threehourweather.model

import android.util.Log
import com.example.threehourweather.viewmodel.WeatherViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class WeatherNetwork(val viewModel: WeatherViewModel) {
    private val TAG = "WeatherNetwork"

    fun initRetrofit(baseUrl: String) {
        getApi(baseUrl).getCurrentWeather("30067", "9dddf9e5f4045a5ea94e37a6847e4dc0")
            .enqueue(
                object : Callback<CurrentWeatherResponse> {
                    override fun onFailure(call: Call<CurrentWeatherResponse>, t: Throwable) {
                        Log.d(TAG, "onFailure() executed")
                        t.printStackTrace()
                    }

                    override fun onResponse(
                        call: Call<CurrentWeatherResponse>,
                        response: Response<CurrentWeatherResponse>
                    ) {
                        Log.d(TAG, "onResponse() executed: " + response.body().toString())
                        response.body()?.let { viewModel.getCurrentWeatherData(it) }

                    }
                }
            )
    }

    fun getApi(url: String): WeatherApi {
        return Retrofit.Builder().addConverterFactory(GsonConverterFactory.create())
            .baseUrl(url)
            .build().create(WeatherApi::class.java)
    }
}