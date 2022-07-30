package com.hitesh.movieapp.model


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import androidx.annotation.Keep

@Keep
@JsonClass(generateAdapter = true)
data class MovieDetails(
    @Json(name = "actors")
    val actors: List<String?>? = null,
    @Json(name = "contentType")
    val contentType: String? = null,
    @Json(name = "directors")
    val directors: List<String?>? = null,
    @Json(name = "genre")
    val genre: List<String?>? = null,
    @Json(name = "id")
    val id: String? = null,
    @Json(name = "image")
    val image: String? = null,
    @Json(name = "imdb")
    val imdb: String? = null,
    @Json(name = "plot")
    val plot: String? = null,
    @Json(name = "rating")
    val rating: Rating? = null,
    @Json(name = "runtime")
    val runtime: String? = null,
    @Json(name = "title")
    val title: String? = null,
    @Json(name = "top_credits")
    val topCredits: List<TopCredit?>? = null,
    @Json(name = "year")
    val year: String? = null
)