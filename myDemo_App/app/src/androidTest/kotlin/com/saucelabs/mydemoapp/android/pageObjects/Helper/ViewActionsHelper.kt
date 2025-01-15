package com.saucelabs.mydemoapp.android.pageObjects.Helper

import androidx.test.espresso.NoMatchingViewException
import androidx.test.espresso.ViewInteraction
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed

class ViewActionsHelper {

    fun isViewDisplayed(viewId: ViewInteraction): Boolean {
        try {
            viewId.check(matches(isDisplayed()))
            return true
        } catch (e: NoMatchingViewException) {
            return false
        }
    }

}
