package com.saucelabs.mydemoapp.android.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters


data class ProductModel(
    var product1: String = "",
    var product2: String = "",
)
