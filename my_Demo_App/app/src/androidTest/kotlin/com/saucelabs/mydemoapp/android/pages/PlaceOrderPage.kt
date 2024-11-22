package com.saucelabs.mydemoapp.android.pages

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.ViewInteraction
import androidx.test.espresso.matcher.ViewMatchers.withId
import com.saucelabs.mydemoapp.android.R
import com.saucelabs.mydemoapp.android.actions.ViewActions
import com.saucelabs.mydemoapp.android.constants.ScreenshotName

class PlaceOrderPage {

    private val handleView = ViewActions()

    //Review Order
    private val reviewOrderText: ViewInteraction = onView(withId(R.id.enterShippingAddressTV))
    private val placeOrderRecycler: ViewInteraction = onView(withId(R.id.placeOrderRV))
    private val fullNameTextReview: ViewInteraction = onView(withId(R.id.fullNameTV))
    private val addressTextReview: ViewInteraction = onView(withId(R.id.addressTV))
    private val cityTextReview: ViewInteraction = onView(withId(R.id.cityTV))
    private val countryTextReview: ViewInteraction = onView(withId(R.id.countryTV))
    private val cardHolderTextReview: ViewInteraction = onView(withId(R.id.cardHolderTV))
    private val cardNumberTextReview: ViewInteraction = onView(withId(R.id.cardNumberTV))
    private val totalTextTV: ViewInteraction = onView(withId(R.id.totalTextTV))
    private val paymentButton: ViewInteraction = onView(withId(R.id.paymentBtn))

    //CheckOut Complete
    private val completeText: ViewInteraction = onView(withId(R.id.completeTV))
    private val thankYouText: ViewInteraction = onView(withId(R.id.thankYouTV))
    private val swagText: ViewInteraction = onView(withId(R.id.swagTV))
    private val orderText: ViewInteraction = onView(withId(R.id.orderTV))
    private val continueShoppingButton: ViewInteraction = onView(withId(R.id.shoopingBt))

    fun clickOnPlaceOrderButton(){
        handleView.performClick(paymentButton)
        Screenshot.takeScreenShot(ScreenshotName.CHECK_COMPLETE)
    }
    fun clickOnReviewOrderButton(){
        handleView.performClick(paymentButton)
        Screenshot.takeScreenShot(ScreenshotName.REVIEW_ORDER)
    }
    fun clickOnContinueShoppingButton(){
        handleView.performClick(continueShoppingButton)
        Screenshot.takeScreenShot(ScreenshotName.HOME_PAGE)
    }
}