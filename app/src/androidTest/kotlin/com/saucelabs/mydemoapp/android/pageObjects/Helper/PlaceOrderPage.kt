package com.saucelabs.mydemoapp.android.pageObjects.Helper

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.ViewInteraction
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.matcher.ViewMatchers
import com.saucelabs.mydemoapp.android.R

class PlaceOrderPage {
    private val reviewOrder: ViewInteraction = onView(ViewMatchers.withId(R.id.paymentBtn))
    private val checkOut: ViewInteraction = onView(ViewMatchers.withId(R.id.completeTV))
    private val continueShopping: ViewInteraction = onView(ViewMatchers.withId(R.id.shoopingBt))

    fun placeOrder() {
        reviewOrder.perform(click())

    }

    fun completCheckOut() {
        continueShopping.perform(click())
    }
}