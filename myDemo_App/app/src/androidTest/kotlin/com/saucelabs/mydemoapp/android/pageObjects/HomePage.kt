package com.saucelabs.mydemoapp.android.pageObjects

import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.ViewInteraction
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.hasDescendant
import androidx.test.espresso.matcher.ViewMatchers.withText
import com.saucelabs.mydemoapp.android.R
import com.saucelabs.mydemoapp.android.pageObjects.Helper.ViewActionsHelper


class HomePage {

    private val viewActionsHelper = ViewActionsHelper()

    private val recyclerViewId  : ViewInteraction = onView(ViewMatchers.withId(R.id.productRV))
    private val productsText: ViewInteraction = onView(ViewMatchers.withId(R.id.productTV))


    fun clickOnProductPosition() {
        recyclerViewId.perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                0,
                click()
            ))
    }

    fun clickOnProductByText(text: String) {
        recyclerViewId.perform(
            RecyclerViewActions.actionOnItem<RecyclerView.ViewHolder>(
                hasDescendant(withText(text)),
                click()
            )
        )
    }
    fun isProductTextDisplayed(): Boolean {
        return viewActionsHelper.isViewDisplayed(productsText)
    }

}