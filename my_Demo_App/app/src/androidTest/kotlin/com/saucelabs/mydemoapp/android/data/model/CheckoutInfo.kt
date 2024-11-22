package com.saucelabs.mydemoapp.android.data.model

import kotlinx.serialization.Serializable

@Serializable
data class CheckoutInfo(
    var firstName: String = "",
    var lastName: String = "",
    var address1: String = "",
    var address2: String = "",
    val paymentMethod: String="",
    var city: String = "",
    var state: String = "",
    var zip: String = "",
    var country: String = "",
    var cardHolderName: String = "",
    var cardNumber: String = "",
    var expirationDate: String = "",
    var securityCode: String = "",
    var isSameShipping: Boolean = false
)

