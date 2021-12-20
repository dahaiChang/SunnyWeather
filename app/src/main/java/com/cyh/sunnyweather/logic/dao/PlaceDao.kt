package com.cyh.sunnyweather.logic.dao

import android.content.Context
import androidx.core.content.edit
import com.cyh.sunnyweather.logic.model.Place
import com.cyh.sunnyweather.SunnyWeatherApplication
import com.google.gson.Gson

/**
 * 必要的存储和读取数据的接口
 */
object PlaceDao {
    fun savePlace(place: Place){
        sharedPreferences().edit{
            putString("place", Gson().toJson(place))
        }
    }
    fun getSavedPlace():Place{
        val placeJson = sharedPreferences().getString("place","")
        return Gson().fromJson(placeJson,Place::class.java)
    }

    //用于判断是否有数据已被存储
    fun isPlaceSaved() = sharedPreferences().contains("place")

    private fun sharedPreferences() = SunnyWeatherApplication.context.getSharedPreferences("sunny_weather",
        Context.MODE_PRIVATE)
}