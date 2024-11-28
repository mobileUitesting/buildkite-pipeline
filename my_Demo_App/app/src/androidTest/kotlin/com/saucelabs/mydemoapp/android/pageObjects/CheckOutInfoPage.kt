package com.saucelabs.mydemoapp.android.pageObjects

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.ViewInteraction
import androidx.test.espresso.matcher.ViewMatchers.withId
import com.saucelabs.mydemoapp.android.R
import com.saucelabs.mydemoapp.android.pageObjects.Helper.ViewActions
import com.saucelabs.mydemoapp.android.data.model.ShippingAddress


class CheckOutInfoPage {
    private val handleView = ViewActions()

    private val fullNameET: ViewInteraction = onView(withId(R.id.fullNameET))
    private val address1ET: ViewInteraction = onView(withId(R.id.address1ET))
    private val address2ET: ViewInteraction = onView(withId(R.id.address2ET))
    private val cityET: ViewInteraction = onView(withId(R.id.cityET))
    private val stateET: ViewInteraction = onView(withId(R.id.stateET))
    private val zipET: ViewInteraction = onView(withId(R.id.zipET))
    private val countryET: ViewInteraction = onView(withId(R.id.countryET))
    private val toPaymentButton: ViewInteraction = onView(withId(R.id.paymentBtn))



    fun fillShippingAddressDetails(shippingAddress: ShippingAddress){
        handleView.performTypeText(fullNameET,shippingAddress.fullName)
        handleView.performTypeText(address1ET,shippingAddress.address1)
        handleView.performTypeText(address2ET,shippingAddress.address2)
        handleView.performTypeText(cityET,shippingAddress.city)
        handleView.performTypeText(stateET,shippingAddress.state)
        handleView.performTypeText(zipET,shippingAddress.zip)
        handleView.performTypeText(countryET,shippingAddress.country)
   }
    fun clickToPaymentButton(){
        handleView.performScrollClick(toPaymentButton)
    }




}