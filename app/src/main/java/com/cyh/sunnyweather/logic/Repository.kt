package com.cyh.sunnyweather.logic

import androidx.lifecycle.liveData
import com.cyh.sunnyweather.logic.model.Place
import com.cyh.sunnyweather.logic.network.SunnyWeatherNetWork
import kotlinx.coroutines.Dispatchers
import java.lang.Exception
import java.lang.RuntimeException

/**
 * 仓库层-判断调用方请求的数据应该是从本地数据源中获取还是从网络数据源中获
取，并将获得的数据返回给调用方。
 */
object Repository {
    fun searchPlaces(query: String) = liveData(Dispatchers.IO) {
        val result = try {
            val placeResponse = SunnyWeatherNetWork.searchPlaces(query)
            if (placeResponse.status == "ok"){
                val places = placeResponse.places
                Result.success(places)
            }else{
                Result.failure(RuntimeException("response status is ${placeResponse.status}"))
            }
        }catch (e:Exception){
            Result.failure<List<Place>>(e)
        }
        emit(result)//将包装的结果发射出去
    }
}