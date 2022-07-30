package com.hitesh.movieapp.model


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import androidx.annotation.Keep

@Keep
@JsonClass(generateAdapter = true)
data class Rating(
    @Json(name = "count")
    val count: Int? = null,
    @Json(name = "star")
    val star: Double? = null
)