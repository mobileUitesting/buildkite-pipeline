package com.saucelabs.mydemoapp.android.pageObjects.Helper

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.ViewInteraction
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers
import com.saucelabs.mydemoapp.android.R

class LogoutPage {
    private val menuIcon: ViewInteraction = onView(ViewMatchers.withId(R.id.menuIV))
    private val LogoutBtn: ViewInteraction = onView(ViewMatchers.withText("Log Out"))
    private val confirmLogout: ViewInteraction = onView(ViewMatchers.withText("Log Out"))
    private val loginView: ViewInteraction = onView(ViewMatchers.withText("Log In"))

    fun menuClick() {
        menuIcon.perform(click())
    }

    fun logout() {
        menuIcon.perform(click())
        LogoutBtn.perform(click())
        confirmLogoutBtn()
    }

    fun confirmLogoutBtn() {
        confirmLogout.perform(click())
    }

    private fun assertLoggedOut() {
        try {
            loginView.check(matches(ViewMatchers.isDisplayed()))

            println("Assertion Passed: Log In screen is displayed after logout.")
        } catch (e: AssertionError) {

            println("Assertion Failed: Log In screen is not displayed after logout.")
            throw e
        }
    }
}