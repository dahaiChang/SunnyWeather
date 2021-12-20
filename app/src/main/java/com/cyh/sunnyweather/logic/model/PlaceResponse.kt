package com.cyh.sunnyweather.logic.model
import com.google.gson.annotations.SerializedName

/**
 * 搜索全球城市数据模型
 */
data class PlaceResponse(
    @SerializedName("places")
    val places: List<Place>,
    @SerializedName("query")
    val query: String,
    @SerializedName("status")
    val status: String
)

data class Place(
    @SerializedName("formatted_address")
    val formattedAddress: String,
    @SerializedName("id")
    val id: String,
    @SerializedName("location")
    val location: Location,
    @SerializedName("name")
    val name: String,
    @SerializedName("place_id")
    val placeId: String
)

data class Location(
    @SerializedName("lng")
    val lng: String,
    @SerializedName("lat")
    val lat: String
)