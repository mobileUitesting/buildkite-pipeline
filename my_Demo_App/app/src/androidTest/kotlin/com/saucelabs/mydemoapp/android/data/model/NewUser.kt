package com.saucelabs.mydemoapp.android.data.model

data class NewUser(
    val fullName: String="",
    val userEmail: String="",
    val userPassword: String="",
    val wrongPassword: String="",
    val invalidPatternEmail: String=""
)
