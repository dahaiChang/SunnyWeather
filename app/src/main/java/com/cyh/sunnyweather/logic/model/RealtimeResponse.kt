package com.cyh.sunnyweather.logic.model
import com.google.gson.annotations.SerializedName

/**
 * 实时天气数据模型
 */
data class RealtimeResponse(
    @SerializedName("api_status")
    val apiStatus: String,
    @SerializedName("api_version")
    val apiVersion: String,
    @SerializedName("lang")
    val lang: String,
    @SerializedName("location")
    val location: List<Double>,
    @SerializedName("result")
    val result: Result,
    @SerializedName("server_time")
    val serverTime: Double,
    @SerializedName("status")
    val status: String,
    @SerializedName("timezone")
    val timezone: String,
    @SerializedName("tzshift")
    val tzshift: Double,
    @SerializedName("unit")
    val unit: String
)

data class Result(
    @SerializedName("primary")
    val primary: Double,
    @SerializedName("realtime")
    val realtime: Realtime
)

data class Realtime(
    @SerializedName("air_quality")
    val airQuality: AirQuality,
    @SerializedName("apparent_temperature")
    val apparentTemperature: Double,
    @SerializedName("cloudrate")
    val cloudrate: Double,
    @SerializedName("dswrf")
    val dswrf: Double,
    @SerializedName("humidity")
    val humidity: Double,
    @SerializedName("life_index")
    val lifeIndex: LifeIndex,
    @SerializedName("precipitation")
    val precipitation: Precipitation,
    @SerializedName("pressure")
    val pressure: Double,
    @SerializedName("skycon")
    val skycon: String,
    @SerializedName("status")
    val status: String,
    @SerializedName("temperature")
    val temperature: Double,
    @SerializedName("visibility")
    val visibility: Double,
    @SerializedName("wind")
    val wind: Wind
)

data class AirQuality(
    @SerializedName("aqi")
    val aqi: Aqi,
    @SerializedName("co")
    val co: Double,
    @SerializedName("description")
    val description: Description,
    @SerializedName("no2")
    val no2: Double,
    @SerializedName("o3")
    val o3: Double,
    @SerializedName("pm10")
    val pm10: Double,
    @SerializedName("pm25")
    val pm25: Double,
    @SerializedName("so2")
    val so2: Double
)

data class LifeIndex(
    @SerializedName("comfort")
    val comfort: Comfort,
    @SerializedName("ultraviolet")
    val ultraviolet: Ultraviolet
)

data class Precipitation(
    @SerializedName("local")
    val local: Local
)

data class Wind(
    @SerializedName("direction")
    val direction: Double,
    @SerializedName("speed")
    val speed: Double
)

data class Aqi(
    @SerializedName("chn")
    val chn: Double,
    @SerializedName("usa")
    val usa: Double
)

data class Description(
    @SerializedName("chn")
    val chn: String,
    @SerializedName("usa")
    val usa: String
)

data class Comfort(
    @SerializedName("desc")
    val desc: String,
    @SerializedName("index")
    val index: Double
)

data class Ultraviolet(
    @SerializedName("desc")
    val desc: String,
    @SerializedName("index")
    val index: Double
)

data class Local(
    @SerializedName("datasource")
    val datasource: String,
    @SerializedName("Doubleensity")
    val Doubleensity: Double,
    @SerializedName("status")
    val status: String
)