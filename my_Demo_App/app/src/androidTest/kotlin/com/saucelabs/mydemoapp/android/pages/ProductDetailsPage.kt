package com.saucelabs.mydemoapp.android.pages

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.ViewInteraction
import androidx.test.espresso.matcher.ViewMatchers.withId
import com.saucelabs.mydemoapp.android.R
import com.saucelabs.mydemoapp.android.actions.ViewActions
import com.saucelabs.mydemoapp.android.actions.Wait

class ProductDetailsPage {

    private val handleView = ViewActions()


    private val productText: ViewInteraction = onView(withId(R.id.productTV))
    private val productImage: ViewInteraction = onView(withId(R.id.productIV))
    private val priceText: ViewInteraction = onView(withId(R.id.priceTV))
    private val rattingV: ViewInteraction = onView(withId(R.id.rattingV))
    private val colorRV: ViewInteraction = onView(withId(R.id.colorRV))
    private val minusImage: ViewInteraction = onView(withId(R.id.minusIV))
    private val plusImage: ViewInteraction = onView(withId(R.id.plusIV))
    private val noTV: ViewInteraction = onView(withId(R.id.noTV))
    private val addToCartButton: ViewInteraction = onView(withId(R.id.cartBt))
    private val productHeightLightsText: ViewInteraction = onView(withId(R.id.productHeightLightsTV))
    private val productDescriptionText: ViewInteraction = onView(withId(R.id.descTV))


    fun increaseProducts(noItems:Int){
        for (i in 1..noItems) {
          handleView.performClick(plusImage)
        }
    }
    fun decreaseProducts(noItems:Int){
        for (i in 1..noItems) {
            handleView.performClick(minusImage)
        }
    }

    fun addToCart(){
        handleView.performScrollClick(addToCartButton)
    }

    fun waitForProductName(){
        Wait.waitView(productText)
    }

}