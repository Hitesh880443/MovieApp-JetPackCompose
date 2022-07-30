package com.hitesh.movieapp.util

import android.content.Context
import android.content.res.AssetManager
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory

inline fun <reified T> AssetManager.readAssetsFile(fileName: String):T? {
    val data  = open(fileName).bufferedReader().use { it.readText() }

    return Moshi.Builder()
        .build().adapter(T::class.java).fromJson(data)
}


inline fun <reified T> readRawJsonFile(rawFile: Int, context:Context): T? {
    val resource = context.resources.openRawResource(rawFile)
        .bufferedReader().use { it.readText() }
    return Moshi.Builder()
        .add(KotlinJsonAdapterFactory())
        .build().adapter(T::class.java).fromJson(resource)
}

