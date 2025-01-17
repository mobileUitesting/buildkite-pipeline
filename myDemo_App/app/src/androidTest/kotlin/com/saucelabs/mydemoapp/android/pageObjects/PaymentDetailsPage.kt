package com.saucelabs.mydemoapp.android.pageObjects

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.ViewInteraction
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.matcher.ViewMatchers
import com.saucelabs.mydemoapp.android.R
import com.saucelabs.mydemoapp.android.data.model.CardPaymentDetails

class PaymentDetailsPage {

    private val fullNameET : ViewInteraction = onView(ViewMatchers.withId(R.id.nameET))
    private val cardNumber : ViewInteraction = onView(ViewMatchers.withId(R.id.cardNumberET))
    private val expiryDate : ViewInteraction = onView(ViewMatchers.withId(R.id.expirationDateET))
    private val securityCode : ViewInteraction = onView(ViewMatchers.withId(R.id.securityCodeET))
    private val paymentOrder : ViewInteraction = onView(ViewMatchers.withId(R.id.paymentBtn))


    fun paymentDetailsSubmit(cardPaymentDetails : CardPaymentDetails)
    {
        fullNameET.perform(typeText(cardPaymentDetails.fullName))
        cardNumber.perform(typeText(cardPaymentDetails.cardNumber))
        expiryDate.perform(typeText(cardPaymentDetails.expiryDate))
        securityCode.perform(typeText(cardPaymentDetails.securityCode))

    }
    fun paymentOrderClick()
    {
        paymentOrder.perform(click())
    }
}