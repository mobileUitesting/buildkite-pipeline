package com.saucelabs.mydemoapp.android.pageObjects

import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.ViewInteraction
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.hasDescendant
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import com.saucelabs.mydemoapp.android.R


class ProductHomePage {

    private val menuView: ViewInteraction = onView(ViewMatchers.withId(R.id.menuIV))
    private val sortView: ViewInteraction = onView(ViewMatchers.withId(R.id.sortIV))
    private val cartView: ViewInteraction = onView(ViewMatchers.withId(R.id.cartRL))
    private val assertAction: ViewInteraction = onView(ViewMatchers.withText("Sauce Labs BackPack (orange)"))

    fun clickOnProductPosition() {
        onView(withId(R.id.productRV))
            .perform(
                RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                    0,
                    click()))
    }

      fun clickOnProductByText(text: String) {
        onView(withId(R.id.productRV))
            .perform(
                RecyclerViewActions.actionOnItem<RecyclerView.ViewHolder>(
                    hasDescendant(withText(text)),
                    click()
                )
            )
    }
}