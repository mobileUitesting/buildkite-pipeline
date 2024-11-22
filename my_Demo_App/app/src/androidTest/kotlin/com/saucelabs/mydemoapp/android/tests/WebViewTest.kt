package com.saucelabs.mydemoapp.android.tests

import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.saucelabs.mydemoapp.android.R
import com.saucelabs.mydemoapp.android.actions.SideNavClickAction
import com.saucelabs.mydemoapp.android.actions.Wait
import com.saucelabs.mydemoapp.android.base.BaseTest
import com.saucelabs.mydemoapp.android.base.ErrorFlow
import com.saucelabs.mydemoapp.android.base.HappyFlow
import com.saucelabs.mydemoapp.android.screenshot.SauceLabsCustomScreenshot
import com.saucelabs.mydemoapp.android.view.activities.SplashActivity
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


class WebViewTest : BaseTest<SplashActivity>(SplashActivity::class.java) {
    var url: String? = null

    @Rule
    var activityRule
            : ActivityScenarioRule<SplashActivity> =
        ActivityScenarioRule(SplashActivity::class.java)

    @Before
    override fun setUp() {
        url = "https://www.google.com"
    }

    @After
    fun cleanup() {
    }

    @Test
    @ErrorFlow
    @Throws(InterruptedException::class)
    fun withoutUrlTest() {
        Wait.waitView(ViewMatchers.withId(R.id.menuIV))

        SauceLabsCustomScreenshot.capture("launch-screen")

        // Open Drawer to click on navigation.
        Espresso.onView(ViewMatchers.withId(R.id.menuIV)).perform(ViewActions.click())

        Espresso.onView(ViewMatchers.withId(R.id.menuRV)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                1,
                SideNavClickAction()
            )
        )

        Espresso.onView(ViewMatchers.withId(R.id.goBtn)).perform(ViewActions.click())
        Espresso.onView(ViewMatchers.withId(R.id.fragment_container))
            .check(ViewAssertions.matches((ViewMatchers.isDisplayed())))

        SauceLabsCustomScreenshot.capture("error-screen")

        Espresso.onView(ViewMatchers.withText("Please provide a correct https url."))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }

    @Test
    @HappyFlow
    fun webViewTest() {
        Wait.waitView(ViewMatchers.withId(R.id.menuIV))

        // Open Drawer to click on navigation.
        Espresso.onView(ViewMatchers.withId(R.id.menuIV)).perform(ViewActions.click())

        Espresso.onView(ViewMatchers.withId(R.id.menuRV)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                1,
                SideNavClickAction()
            )
        )

        Espresso.onView(ViewMatchers.withId(R.id.urlET))
            .perform(ViewActions.typeText(url), ViewActions.closeSoftKeyboard())
        Espresso.onView(ViewMatchers.withId(R.id.goBtn))
            .perform(ViewActions.click())

        Espresso.onView(ViewMatchers.withText("Please provide a correct https url."))
            .check(ViewAssertions.doesNotExist())
    }
}
