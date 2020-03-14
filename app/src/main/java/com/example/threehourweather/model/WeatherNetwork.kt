package com.example.threehourweather.model

import android.util.Log
import com.example.threehourweather.viewmodel.WeatherViewModel
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class WeatherNetwork(val viewModel: WeatherViewModel) {
    private val TAG = "WeatherNetwork"

    fun initRetrofit(baseUrl: String) {
        getApi(baseUrl).getCurrentWeather()
            .enqueue(
                object : Callback<WeatherResponse> {
                    override fun onFailure(call: Call<WeatherResponse>, t: Throwable) {
                        Log.d(TAG, "onFailure() executed")

                    }

                    override fun onResponse(
                        call: Call<WeatherResponse>,
                        response: Response<WeatherResponse>
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