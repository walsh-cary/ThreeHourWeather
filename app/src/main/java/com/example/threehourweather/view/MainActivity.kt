package com.example.threehourweather.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.threehourweather.R

class MainActivity : AppCompatActivity() {

// http://api.openweathermap.org/data/2.5/weather?q=Marietta,ga&APPID=9dddf9e5f4045a5ea94e37a6847e4dc0
// http://api.openweathermap.org/data/2.5/forecast?q=Marietta,ga&APPID=9dddf9e5f4045a5ea94e37a6847e4dc0
// http://api.openweathermap.org/data/2.5/forecast/hourly?q=Marietta,ga&APPID=9dddf9e5f4045a5ea94e37a6847e4dc0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
