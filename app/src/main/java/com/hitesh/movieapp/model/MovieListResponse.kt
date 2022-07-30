package com.hitesh.movieapp.model



import androidx.annotation.Keep
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@Keep
@JsonClass(generateAdapter = true)
data class MovieListResponse(
    @Json(name = "query")
    val query: String? = null,
    @Json(name = "results")
    val results: List<Movie>? = null
)