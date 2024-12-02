package com.saucelabs.mydemoapp.android.data


import com.saucelabs.mydemoapp.android.data.model.ConfigDetails
import com.saucelabs.mydemoapp.android.utils.JsonParser
import com.saucelabs.mydemoapp.android.utils.PropertyParser
import com.saucelabs.mydemoapp.android.data.model.LoginCredentials
import com.saucelabs.mydemoapp.android.data.model.PaymentDetails
import com.saucelabs.mydemoapp.android.data.model.ProductModel
import com.saucelabs.mydemoapp.android.data.model.ShippingAddress
import com.saucelabs.mydemoapp.android.data.model.UserDetails


class DataLoader {
    private lateinit var properties: PropertyParser
    private lateinit var jsonloader: JsonParser

    fun getConfigDetails(): ConfigDetails{
        properties= PropertyParser("config.properties")
        val secretKey = properties.getPropertyValue("secretKey")
        return ConfigDetails(secretKey)
    }


    fun getLoginCredentials(): LoginCredentials {
        jsonloader = JsonParser()
        val loginDetails: LoginCredentials = jsonloader.parseJson("testdata/loginCredentials.json")
        val userEmail = loginDetails.userEmail
        val password = loginDetails.userPassword
        val invalidUserEmail = loginDetails.invalidUserEmail
        val invalidPassword = loginDetails.invalidUserPassword
        return LoginCredentials(userEmail, password, invalidUserEmail, invalidPassword)
    }

    fun getUserDetails(): UserDetails {
        jsonloader = JsonParser()
        val userDetails: UserDetails = jsonloader.parseJson("testdata/userDetails.json")
        return UserDetails(
            userDetails.firstName,
            userDetails.lastName,
            userDetails.email,
            userDetails.phoneNumber
        )
    }

    fun getShippingAddressDetails(): ShippingAddress {
        jsonloader = JsonParser()
        val shippingAddressDetails: ShippingAddress =
            jsonloader.parseJson("testdata/shippingAddress.json")
        return ShippingAddress(
            shippingAddressDetails.fullName,
            shippingAddressDetails.address1,
            shippingAddressDetails.address2,
            shippingAddressDetails.city,
            shippingAddressDetails.state,
            shippingAddressDetails.zip,
            shippingAddressDetails.country
        )
    }

    fun getPaymentDetails(): PaymentDetails {
        jsonloader = JsonParser()
        val paymentDetails: PaymentDetails = jsonloader.parseJson("testdata/paymentDetails.json")
        return PaymentDetails(
            paymentDetails.cardHolderName,
            paymentDetails.cardNumber,
            paymentDetails.expiredDate,
            paymentDetails.securityCode
        )
    }
    fun getProducts(): ProductModel {
        jsonloader = JsonParser()
        val products: ProductModel = jsonloader.parseJson("testdata/products.json")
        return ProductModel(
            products.product1,
            products.product2,
        )
    }
}