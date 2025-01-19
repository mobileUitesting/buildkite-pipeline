package com.saucelabs.mydemoapp.android.pageObjects

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.ViewInteraction
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.matcher.ViewMatchers
import com.saucelabs.mydemoapp.android.R
import com.saucelabs.mydemoapp.android.constants.AppConstants
import com.saucelabs.mydemoapp.android.pageObjects.Helper.ViewActionsHelper

class ProductCartPage {

    private val viewActionsHelper = ViewActionsHelper()

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
        //cartEmptylist.perform(click())
        viewActionsHelper.performClick(AppConstants.GOSHOPPING)
    }
}
