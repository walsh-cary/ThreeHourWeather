package com.example.threehourweather.model

import android.util.Log
import com.example.threehourweather.viewmodel.WeatherViewModel
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class WeatherNetwork(val viewModel: WeatherViewModel) {
    private val TAG = "WeatherNetwork"

    var interceptor : HttpLoggingInterceptor? = null
    var client : OkHttpClient? = null

    fun initRetrofit(baseUrl: String) {
        interceptor = HttpLoggingInterceptor().apply {
            this.level = HttpLoggingInterceptor.Level.BODY
        }

        client = OkHttpClient.Builder().apply {
            this.addInterceptor(interceptor!!)
        } .build()

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
        getApi(baseUrl).getForecastWeather("30067", "9dddf9e5f4045a5ea94e37a6847e4dc0")
            .enqueue(
                object : Callback<ForecastWeatherResponse> {
                    override fun onFailure(call: Call<ForecastWeatherResponse>, t: Throwable) {
                        Log.d(TAG, "onFailure() executed")
                        t.printStackTrace()
                    }

                    override fun onResponse(
                        call: Call<ForecastWeatherResponse>,
                        response: Response<ForecastWeatherResponse>
                    ) {
                        Log.d(TAG, "onResponse() executed: " + response.body().toString())
                        response.body()?.let { viewModel.getForecastWeatherData(it) }
                    }

                }
            )
    }

    fun getApi(url: String): WeatherApi {
        return Retrofit.Builder().addConverterFactory(GsonConverterFactory.create())
            .baseUrl(url)
            .client(client!!)
            .build()
            .create(WeatherApi::class.java)
    }
}