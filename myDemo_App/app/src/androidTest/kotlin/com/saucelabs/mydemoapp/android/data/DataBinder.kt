package com.saucelabs.mydemoapp.android.data


import com.saucelabs.mydemoapp.android.data.model.CardPaymentDetails
import com.saucelabs.mydemoapp.android.data.model.ShippingDetails
import com.saucelabs.mydemoapp.android.data.model.UserCredentials
import com.saucelabs.mydemoapp.android.utils.JsonParser


class DataBinder {

    private lateinit var jsonLoader:JsonParser

    fun getUserCredentials(): UserCredentials {
       jsonLoader = JsonParser()
        val userCredentials: UserCredentials =jsonLoader.parseJson("testdata/loginCredentials.json")
        return userCredentials
    }

    fun getShippingDetails(): ShippingDetails {
        jsonLoader = JsonParser()
        val shippingDetails: ShippingDetails = jsonLoader.parseJson("testdata/shippingAddress.json")
         return shippingDetails
    }

    fun getCardPaymentDetails(): CardPaymentDetails {
        jsonLoader = JsonParser()
        val cardPaymentDetails: CardPaymentDetails = jsonLoader.parseJson("testdata/paymentDetails.json")
              return cardPaymentDetails
    }
}


