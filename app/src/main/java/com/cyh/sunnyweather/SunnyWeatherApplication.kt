package com.cyh.sunnyweather

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context

class SunnyWeatherApplication :Application() {

    companion object{
        //全局获取context
        @SuppressLint("StaticFieldLeak")
        lateinit var context: Context
        //令牌值
        const val TOKEN = "iysJHTQ7QM0TApVL"
    }

    override fun onCreate() {
        super.onCreate()
        context = applicationContext
    }
}