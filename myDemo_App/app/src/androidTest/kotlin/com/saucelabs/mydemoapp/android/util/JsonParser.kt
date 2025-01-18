package com.saucelabs.mydemoapp.android.utils

import android.content.Context
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.io.InputStream

import java.io.InputStreamReader

class JsonParser {

    private var json: JsonParser? = null
    inline fun <reified T> parseJson(jsonFilePath: String): T {
        val gson = Gson()
        val inputStream: InputStream? =
            this::class.java.classLoader?.getResourceAsStream(jsonFilePath)
        val reader = InputStreamReader(inputStream)
        return gson.fromJson(reader, T::class.java)
    }

    inline fun <reified T> parseJsonArray(jsonFilePath: String): List<T> {

        val inputStream: InputStream? =
            this::class.java.classLoader?.getResourceAsStream(jsonFilePath)
        val reader = InputStreamReader(inputStream)
        val type = object : TypeToken<List<T>>() {}.type
        return Gson().fromJson(reader, type)
    }
}