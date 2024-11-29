package com.saucelabs.mydemoapp.android.data.model

data class PaymentDetails(
    var cardHolderName: String = "",
    var cardNumber: String = "",
    var expiredDate: String = "",
    var securityCode: String = "",
)
