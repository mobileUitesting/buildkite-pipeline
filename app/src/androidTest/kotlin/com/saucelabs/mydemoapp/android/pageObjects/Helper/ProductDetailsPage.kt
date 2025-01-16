package com.saucelabs.mydemoapp.android.pageObjects.Helper

import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.ViewInteraction
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.withId
import com.saucelabs.mydemoapp.android.R

class ProductDetailsPage {

    private val productColorItem : ViewInteraction = onView(ViewMatchers.withId(R.id.colorRV))
    private val productAddToCart : ViewInteraction = onView(ViewMatchers.withId(R.id.cartBt))
    private val cartItem : ViewInteraction = onView(ViewMatchers.withId(R.id.cartRL))
    private val plusCart : ViewInteraction = onView(ViewMatchers.withId(R.id.plusIV))
    private val minusCart : ViewInteraction = onView(ViewMatchers.withId(R.id.minusIV))
    private val removeItem : ViewInteraction = onView(ViewMatchers.withId(R.id.removeBt))

    fun productColorClick(position: Int) {
        // Locate the RecyclerView with color options and click on the item at the given position
        onView(withId(R.id.colorRV)) // Replace with the actual ID of your RecyclerView
            .perform(
                RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                    position,
                    click()   // Action to perform
                )
            )
    }

    fun clickOnProductPositionOne(position: Int) {
        onView(withId(R.id.productRV))
            .perform(
                RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                    1,
                    click()))
    }

    fun clickOnProductPositionThree(position: Int)
    {
        onView(withId(R.id.productRV))
            .perform(
                RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                    3,
                    click()))
    }

    fun productCartSelect()
    {
        productAddToCart.perform(click())
    }

    fun cartClick()
    {
        cartItem.perform(click())
    }
    fun addItemClick()
    {
        plusCart.perform(click())
    }
    fun removeItemClick()
    {
        minusCart.perform(click())
    }

}

