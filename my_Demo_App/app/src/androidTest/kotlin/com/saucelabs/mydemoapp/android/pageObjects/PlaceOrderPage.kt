package com.saucelabs.mydemoapp.android.pageObjects

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.ViewInteraction
import androidx.test.espresso.matcher.ViewMatchers.withId
import com.saucelabs.mydemoapp.android.R
import com.saucelabs.mydemoapp.android.pageObjects.Helper.ViewActions

class PlaceOrderPage {

    private val handleView = ViewActions()

    private val paymentButton: ViewInteraction = onView(withId(R.id.paymentBtn))
    private val completeText: ViewInteraction = onView(withId(R.id.completeTV))
    private val continueShoppingButton: ViewInteraction = onView(withId(R.id.shoopingBt))

    fun clickPlaceOrderButton(){
        handleView.performClick(paymentButton)
    }
   fun clickContinueShoppingButton(){
        handleView.performClick(continueShoppingButton)
   }
    fun getCheckoutSuccessMessage():String{
        return handleView.getText(completeText)
    }
}