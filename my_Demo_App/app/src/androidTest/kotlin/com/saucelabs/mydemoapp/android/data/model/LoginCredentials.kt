package com.saucelabs.mydemoapp.android.data.model

data class LoginCredentials(
    val userEmail: String="",
    val userPassword: String="",
    val invalidUserEmail: String="",
    val invalidUserPassword: String=""
  )
