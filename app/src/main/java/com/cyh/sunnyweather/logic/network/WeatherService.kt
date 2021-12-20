package com.cyh.sunnyweather.logic.network

import DailyResponse
import com.cyh.sunnyweather.SunnyWeatherApplication
import com.cyh.sunnyweather.logic.model.RealtimeResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * 访问天气信息API的Retrofit接口
 */
interface WeatherService {
    //用于获取实时的天气信息
    @GET("v2.5/${SunnyWeatherApplication.TOKEN}/{lng},{lat}/realtime.json")
    fun getRealtimeWeather(@Path("lng") lng:String,@Path("lat") lat:String): Call<RealtimeResponse>

    //用于获取未来的天气信息
    @GET("v2.5/${SunnyWeatherApplication.TOKEN}/{lng},{lat}/daily.json")
    fun getDailyWeather(@Path("lng") lng: String, @Path("lat") lat: String) : Call<DailyResponse>
}