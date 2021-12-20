package com.cyh.sunnyweather.logic

import android.util.Log
import androidx.lifecycle.liveData
import com.cyh.sunnyweather.logic.model.Place
import com.cyh.sunnyweather.logic.model.Weather
import com.cyh.sunnyweather.logic.network.SunnyWeatherNetWork
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import java.lang.Exception
import java.lang.RuntimeException
import kotlin.math.log

/**
 * 仓库层-判断调用方请求的数据应该是从本地数据源中获取还是从网络数据源中获
取，并将获得的数据返回给调用方。
 */
object Repository {
    /**
     * 全球城市
     */
    fun searchPlaces(query: String) = liveData(Dispatchers.IO) {
        val result = try {
            val placeResponse = SunnyWeatherNetWork.searchPlaces(query)
            if (placeResponse.status == "ok") {
                val places = placeResponse.places
                Result.success(places)
            } else {
                Result.failure(RuntimeException("response status is ${placeResponse.status}"))
            }
        } catch (e: Exception) {
            Result.failure<List<Place>>(e)
        }
        emit(result)//将包装的结果发射出去
    }

    /**
     * 天气信息
     */
    fun refreshWeather(lng: String, lat: String) = liveData(Dispatchers.IO) {
        val result = try {
            coroutineScope {
                val deferredRealtime = async {
                    Log.e("TAG", "refreshWeather: getRealtimeWeather "+lng+ "----"+lat)
                    SunnyWeatherNetWork.getRealtimeWeather(lng, lat)
                }

                val deferredDaily = async {
                    Log.e("TAG", "refreshWeather: getDailyWeather "+lng+ "----"+lat)
                    SunnyWeatherNetWork.getDailyWeather(lng, lat)
                }
                val realtimeResponse = deferredRealtime.await()
                val dailyResponse = deferredDaily.await()
                if (realtimeResponse.status == "ok" && dailyResponse.status == "ok") {
                    val weather =
                        Weather(realtimeResponse.result.realtime, dailyResponse.result.daily)
                    Result.success(weather)
                } else {
                    Result.failure(
                        RuntimeException(
                            "realtime response status is ${realtimeResponse.status}" +
                                    " daily response status is ${dailyResponse.status}"
                        )
                    )
                }
            }
        } catch (e: Exception) {
            Result.failure<Weather>(e)
        }
        emit(result)
    }
}