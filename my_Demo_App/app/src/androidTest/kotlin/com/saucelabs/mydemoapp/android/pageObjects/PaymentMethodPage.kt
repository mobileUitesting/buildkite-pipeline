package com.saucelabs.mydemoapp.android.pageObjects

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.ViewInteraction
import androidx.test.espresso.matcher.ViewMatchers.withId
import com.saucelabs.mydemoapp.android.R
import com.saucelabs.mydemoapp.android.pageObjects.Helper.ViewActions
import com.saucelabs.mydemoapp.android.data.model.PaymentDetails

class PaymentMethodPage {


    private val handleView = ViewActions()

    private val nameET: ViewInteraction = onView(withId(R.id.nameET))
    private val cardNumberET: ViewInteraction = onView(withId(R.id.cardNumberET))
    private val expirationDateET: ViewInteraction = onView(withId(R.id.expirationDateET))
    private val securityCodeET: ViewInteraction = onView(withId(R.id.securityCodeET))
    private val reviewOrderButton: ViewInteraction = onView(withId(R.id.paymentBtn))

    fun fillPaymentDetails(paymentDetails: PaymentDetails) {
        handleView.performTypeText(nameET,paymentDetails.cardHolderName)
        handleView.performTypeText(cardNumberET, paymentDetails.cardNumber)
        handleView.performTypeText(expirationDateET, paymentDetails.expiredDate)
        handleView.performTypeText(securityCodeET, paymentDetails.securityCode)
    }
    fun clickReviewOrderButton() {
        handleView.performClick(reviewOrderButton)
    }


}