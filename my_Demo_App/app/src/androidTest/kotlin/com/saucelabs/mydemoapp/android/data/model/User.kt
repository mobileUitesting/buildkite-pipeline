package com.saucelabs.mydemoapp.android.data.model

import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey

@Entity(tableName = "person")
data class User(
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0,
    var name: String,
    var email: String,
    var number: String,
    var pincode: String,
    var city: String
) {
    @Ignore
    constructor(name: String, email: String, number: String, pincode: String, city: String) : this(
        id = 0,
        name = name,
        email = email,
        number = number,
        pincode = pincode,
        city = city
    )
}
