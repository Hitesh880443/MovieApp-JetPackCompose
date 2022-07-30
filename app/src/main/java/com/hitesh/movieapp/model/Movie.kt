package com.hitesh.movieapp.model


import androidx.annotation.Keep
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@Keep
@JsonClass(generateAdapter = true)
data class Movie(
    @Json(name = "id")
    val id: String? = null,
    @Json(name = "title")
    val title: String? = null,
    @Json(name = "image")
    val image: String? = null,
    @Json(name = "image_large")
    val imageLarge: String? = null,
    @Json(name = "api_path")
    val apiPath: String? = null,
    @Json(name = "imdb")
    val imdb: String? = null
)