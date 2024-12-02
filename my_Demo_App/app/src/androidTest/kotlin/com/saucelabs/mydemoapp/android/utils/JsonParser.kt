package com.saucelabs.mydemoapp.android.utils

import androidx.test.platform.app.InstrumentationRegistry

import com.google.gson.Gson
import com.google.gson.JsonParser
import com.google.gson.reflect.TypeToken
import java.io.InputStream
import java.io.InputStreamReader
import java.lang.reflect.Type

class JsonParser{
    private var json: JsonParser? =null

      inline fun <reified T> parseJson(jsonFilePath: String): T {
        val gson = Gson()

         val inputStream: InputStream? =
             this::class.java.classLoader?.getResourceAsStream(jsonFilePath)
         val reader = InputStreamReader(inputStream)
        return gson.fromJson(reader, T::class.java)
    }

    fun readJson(jsonFilePath: String): List<Any>? {
        var dataList: List<Any>? = null
        try {
            val inputStream: InputStream = InstrumentationRegistry.getInstrumentation()
                .targetContext.assets.open(jsonFilePath)
            val reader = InputStreamReader(inputStream)

            val listType: Type = object : TypeToken<List<Any>>() {}.type
            dataList = Gson().fromJson(reader, listType)
            reader.close()
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return dataList
    }
}