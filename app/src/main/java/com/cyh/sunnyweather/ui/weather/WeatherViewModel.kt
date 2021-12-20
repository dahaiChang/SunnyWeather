package com.cyh.sunnyweather.ui.weather

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.cyh.sunnyweather.logic.Repository
import com.cyh.sunnyweather.logic.model.Location

/**
 * 天气
 */
class WeatherViewModel : ViewModel() {
    private val localtionLiveData = MutableLiveData<Location>()
    var locationLng = ""
    var locationLat = ""
    var placeName = ""
    val weatherLiveData = Transformations.switchMap(localtionLiveData){ location ->
        Repository.refreshWeather(location.lng,location.lat)
    }
    fun refreshWeather(lng:String,lat:String){
        localtionLiveData.value = Location(lng,lat)
    }
}