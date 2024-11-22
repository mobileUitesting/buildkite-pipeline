package com.saucelabs.mydemoapp.android.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters

@Entity(tableName = "Product")
data class ProductModel(
    @PrimaryKey(autoGenerate = true) var id: Int = 0,
    var title: String = "",
    var price: Double = 0.0,
    var rating: Int = 0,
    var colors: Int = 0,
    var desc: String = "",
    var currency: String = "",
    var image: ByteArray? = null,
    var imageVal: Int = 0,
    @TypeConverters(ColorModelConverters::class) var colorList: List<ColorModel> = emptyList()
)
