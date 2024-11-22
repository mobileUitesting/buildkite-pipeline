package com.saucelabs.mydemoapp.android.tests

import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso
import androidx.test.espresso.ViewAction
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import com.saucelabs.mydemoapp.android.R
import com.saucelabs.mydemoapp.android.actions.NestingAwareScrollAction
import com.saucelabs.mydemoapp.android.actions.Wait
import com.saucelabs.mydemoapp.android.base.BaseTest
import com.saucelabs.mydemoapp.android.base.HappyFlow
import com.saucelabs.mydemoapp.android.view.activities.SplashActivity
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@LargeTest
@RunWith(AndroidJUnit4::class)
class DashboardToCheckout : BaseTest<SplashActivity>(SplashActivity::class.java) {
    //This ViewAction For Nested ScrollView
    private val scroll: ViewAction = NestingAwareScrollAction()

    @Rule
    var activityRule: ActivityScenarioRule<SplashActivity> = ActivityScenarioRule(
        SplashActivity::class.java
    )
    @Test
    @HappyFlow
    fun dashboardProductTest() {
        // Splash screen
        Wait.waitView(ViewMatchers.withId(R.id.menuIV))

        // Check RecyclerView
        Espresso.onView(ViewMatchers.withId(R.id.productRV))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))

        // AfterSelect The Item Which You Want
        Espresso.onView(ViewMatchers.withId(R.id.productRV)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                0,
                ViewActions.click()
            )
        )

        // Confirm That On First Item Click
        Espresso.onView(ViewMatchers.withId(R.id.productTV))
            .check(ViewAssertions.matches(ViewMatchers.withText("Sauce Labs Backpack")))

        // Click To Increment
        Espresso.onView(ViewMatchers.withId(R.id.plusIV))
            .perform(scroll)
            .perform(ViewActions.click())

        // Click To Add to cart
        Espresso.onView(ViewMatchers.withId(R.id.cartBt))
            .perform(scroll)
            .perform(ViewActions.click())

        // Click On Cart Item
        Espresso.onView(ViewMatchers.withId(R.id.cartRL))
            .perform(ViewActions.click())

        // Click On Cart Item:: Fragment Product Detail
        Espresso.onView(ViewMatchers.withId(R.id.cartBt))
            .perform(ViewActions.click())

        // Login User Fragment
        val name = "bod@example.com"
        val pass = "10203040"

        Espresso.onView(ViewMatchers.withId(R.id.nameET))
            .perform(ViewActions.typeText(name))
            .perform(ViewActions.closeSoftKeyboard())

        Espresso.onView(ViewMatchers.withId(R.id.passwordET))
            .perform(ViewActions.typeText(pass))
            .perform(ViewActions.closeSoftKeyboard())

        // Check The Screen
        Espresso.onView(ViewMatchers.withId(R.id.nameET))
            .check(ViewAssertions.matches(ViewMatchers.withText(name)))
        Espresso.onView(ViewMatchers.withId(R.id.passwordET))
            .check(ViewAssertions.matches(ViewMatchers.withText(pass)))

        Espresso.onView(ViewMatchers.withId(R.id.loginBtn))
            .perform(scroll)
            .perform(ViewActions.click())

        // End................................................

        // Fragment Check Out Info
        val uName = "Rebecca Winter"
        val address1 = "Mandorley 112"
        val address2 = "Entrance 1"
        val city = "Truro"
        val state = "Cornwall"
        val zipCode = "89750"
        val country = "United Kingdom"

        Espresso.onView(ViewMatchers.withId(R.id.fullNameET))
            .perform(scroll)
            .perform(ViewActions.typeText(uName))
            .perform(ViewActions.closeSoftKeyboard())

        Espresso.onView(ViewMatchers.withId(R.id.address1ET))
            .perform(scroll)
            .perform(ViewActions.typeText(address1))
            .perform(ViewActions.closeSoftKeyboard())

        Espresso.onView(ViewMatchers.withId(R.id.address2ET))
            .perform(scroll)
            .perform(ViewActions.typeText(address2))
            .perform(ViewActions.closeSoftKeyboard())

        Espresso.onView(ViewMatchers.withId(R.id.cityET))
            .perform(scroll)
            .perform(ViewActions.typeText(city))
            .perform(ViewActions.closeSoftKeyboard())

        Espresso.onView(ViewMatchers.withId(R.id.stateET))
            .perform(scroll)
            .perform(ViewActions.typeText(state))
            .perform(ViewActions.closeSoftKeyboard())

        Espresso.onView(ViewMatchers.withId(R.id.zipET))
            .perform(scroll)
            .perform(ViewActions.typeText(zipCode))
            .perform(ViewActions.closeSoftKeyboard())

        Espresso.onView(ViewMatchers.withId(R.id.countryET))
            .perform(scroll)
            .perform(ViewActions.typeText(country))
            .perform(ViewActions.closeSoftKeyboard())

        Espresso.onView(ViewMatchers.withId(R.id.paymentBtn))
            .perform(scroll)
            .perform(ViewActions.click())

        // End................................................

        // Fragment CheckOut Information
        val name_Checkout = "Rebecca Winter"
        val card_no = "3258125675687891"
        val date = "03/25"
        val securityCode = "123"

        Espresso.onView(ViewMatchers.withId(R.id.nameET))
            .perform(scroll)
            .perform(ViewActions.typeText(name_Checkout), ViewActions.closeSoftKeyboard())
        Espresso.onView(ViewMatchers.withId(R.id.cardNumberET))
            .perform(scroll)
            .perform(ViewActions.typeText(card_no), ViewActions.closeSoftKeyboard())

        Espresso.onView(ViewMatchers.withId(R.id.expirationDateET))
            .perform(scroll)
            .perform(ViewActions.typeText(date), ViewActions.closeSoftKeyboard())
        Espresso.onView(ViewMatchers.withId(R.id.securityCodeET))
            .perform(scroll)
            .perform(ViewActions.typeText(securityCode), ViewActions.closeSoftKeyboard())

        Espresso.onView(ViewMatchers.withText("Review Order"))
            .perform(ViewActions.click())

        // End................................................

        // Place Order Fragment
        Espresso.onView(ViewMatchers.withText("Place Order"))
            .perform(ViewActions.click())

        // End................................................

        // CheckOut Complete
        Espresso.onView(ViewMatchers.withText("Continue Shopping"))
            .perform(scroll)
            .perform(ViewActions.click())

        // End................................................

        // Assert we are back to main page
        Espresso.onView(ViewMatchers.withId(R.id.productRV))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }
}
