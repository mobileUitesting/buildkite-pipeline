package com.saucelabs.mydemoapp.android.pageObjects

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.ViewInteraction
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.closeSoftKeyboard
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.matcher.ViewMatchers
import com.saucelabs.mydemoapp.android.R


class CheckOutDetailsPage {

    private val fullName : ViewInteraction = onView(ViewMatchers.withId(R.id.fullNameET))
    private val addressLine1: ViewInteraction = onView(ViewMatchers.withId(R.id.address1ET))
    private val addressLine2: ViewInteraction = onView(ViewMatchers.withId(R.id.address2ET))
    private val citySel : ViewInteraction = onView(ViewMatchers.withId(R.id.cityET))
    private val stateSel : ViewInteraction = onView(ViewMatchers.withId(R.id.stateET))
    private val zipSel: ViewInteraction = onView(ViewMatchers.withId(R.id.zipET))
    private val countrySel:ViewInteraction = onView(ViewMatchers.withId(R.id.countryET))
    private val paymentButton : ViewInteraction = onView(ViewMatchers.withId(R.id.paymentBtn))


    fun userShippingDetails(shippingDetails : ShippingDetails)
    {
        fullName.perform(typeText(shippingDetails.fullName),closeSoftKeyboard())
        addressLine1.perform(typeText(shippingDetails.addressOne),closeSoftKeyboard())
        addressLine2.perform(typeText(shippingDetails.addressTwo),closeSoftKeyboard())
        citySel.perform(typeText(shippingDetails.city),closeSoftKeyboard())
        stateSel.perform(typeText(shippingDetails.state),closeSoftKeyboard())
        zipSel.perform(typeText(shippingDetails.zip),closeSoftKeyboard())
        countrySel.perform(typeText(shippingDetails.country),closeSoftKeyboard())
    }
    fun paymentButtonClick()
    {
        paymentButton.perform(click())
    }
}

