package com.saucelabs.mydemoapp.android.pageObjects.Helper

import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.ViewInteraction
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.scrollTo
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.withId
import com.saucelabs.mydemoapp.android.R

class ProductCartPage {


    private val productCheckOut: ViewInteraction = onView(ViewMatchers.withId(R.id.cartBt))
    private val removeProductList: ViewInteraction = onView(ViewMatchers.withId(R.id.removeBt))
    private val cartEmptylist : ViewInteraction = onView(ViewMatchers.withId(R.id.shoopingBt))

    fun productOnCheckOut() {
        productCheckOut.perform(click())

    }

    fun productRemoveFromList() {
        removeProductList.perform(click())
    }

    fun EmptyCartClick()
    {
        cartEmptylist.perform(click())
    }
}
