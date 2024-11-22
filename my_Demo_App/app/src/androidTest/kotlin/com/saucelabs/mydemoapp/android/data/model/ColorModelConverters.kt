package com.saucelabs.mydemoapp.android.data.model

import androidx.room.TypeConverter
import com.google.common.reflect.TypeToken
import com.google.gson.Gson
import com.saucelabs.mydemoapp.android.model.ColorModel

class ColorModelConverters {
    var gson: Gson = Gson()

    companion object {
        @TypeConverter
        fun stringToSomeObjectList(data: String?): List<ColorModel> {
            if (data == null) {
                return emptyList()
            }

            val listType = object : TypeToken<List<ColorModel?>?>() {}.type

            return Gson().fromJson(data, listType)
        }

        @TypeConverter
        fun someObjectListToString(someObjects: List<ColorModel?>?): String {
            return Gson().toJson(someObjects)
        }
    }
}