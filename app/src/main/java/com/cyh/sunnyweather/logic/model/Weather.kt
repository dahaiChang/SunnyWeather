package com.cyh.sunnyweather.logic.model

import Daily

/**
 * 用于将Realtime和Daily对象 封装起来
 */
data class Weather(val realtime: Realtime,val daily: Daily)