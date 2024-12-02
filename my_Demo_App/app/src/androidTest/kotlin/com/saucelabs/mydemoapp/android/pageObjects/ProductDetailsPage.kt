package com.saucelabs.mydemoapp.android.pageObjects

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.ViewInteraction
import androidx.test.espresso.matcher.ViewMatchers.withId
import com.saucelabs.mydemoapp.android.R
import com.saucelabs.mydemoapp.android.pageObjects.Helper.ViewActions

class ProductDetailsPage {

    private val handleView = ViewActions()

    private val productText: ViewInteraction = onView(withId(R.id.productTV))
    private val minusImage: ViewInteraction = onView(withId(R.id.minusIV))
    private val plusImage: ViewInteraction = onView(withId(R.id.plusIV))
    private val addToCartButton: ViewInteraction = onView(withId(R.id.cartBt))

    fun addToCart(){
        handleView.performScrollClick(addToCartButton)
    }
}