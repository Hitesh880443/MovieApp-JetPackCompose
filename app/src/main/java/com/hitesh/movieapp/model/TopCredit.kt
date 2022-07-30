package com.hitesh.movieapp.model


import com.squareup.moshi.JsonClass
import androidx.annotation.Keep
import com.squareup.moshi.Json

@Keep
@JsonClass(generateAdapter = true)
data class TopCredit(
    @Json(name = "name")
    val name: String? = null,
    @Json(name = "value")
    val value: List<String?>? = null
)