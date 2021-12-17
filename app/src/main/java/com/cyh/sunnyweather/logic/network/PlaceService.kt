package com.cyh.sunnyweather.logic.network

import com.cyh.sunnyweather.SunnyWeatherApplication
import com.cyh.sunnyweather.logic.model.PlaceResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * 搜索全球城市网络层相关代码
 */
interface PlaceService {
    @GET("v2/place?&token=${SunnyWeatherApplication.TOKEN}&lang=zh_CN")
    fun searchPlaces(@Query("query")query:String):Call<PlaceResponse>
}