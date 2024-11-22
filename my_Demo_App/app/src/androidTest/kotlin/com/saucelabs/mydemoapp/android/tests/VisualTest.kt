package com.saucelabs.mydemoapp.android.tests

import android.text.TextUtils
import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso
import androidx.test.espresso.ViewAction
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.filters.LargeTest
import androidx.test.platform.app.InstrumentationRegistry
import com.saucelabs.mydemoapp.android.BuildConfig
import com.saucelabs.mydemoapp.android.R
import com.saucelabs.mydemoapp.android.actions.NestingAwareScrollAction
import com.saucelabs.mydemoapp.android.actions.SideNavClickAction
import com.saucelabs.mydemoapp.android.actions.Wait
import com.saucelabs.mydemoapp.android.base.BaseTest
import com.saucelabs.mydemoapp.android.utils.SingletonClass
import com.saucelabs.mydemoapp.android.view.activities.SplashActivity
import com.saucelabs.visual.VisualCheckOptions
import com.saucelabs.visual.VisualClient
import com.saucelabs.visual.junit.TestMetaInfoRule
import org.hamcrest.core.AllOf
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@LargeTest

class VisualTest : BaseTest<SplashActivity>(SplashActivity::class.java) {
    private val scroll: ViewAction = NestingAwareScrollAction()

    @Rule
    var activityRule: ActivityScenarioRule<SplashActivity> = ActivityScenarioRule(
        SplashActivity::class.java
    )

    @Rule
    var testMetaInfoRule: TestMetaInfoRule = TestMetaInfoRule()

    @Before
    fun removeLogin() {
        SingletonClass.getInstance().isLogin = false
        SingletonClass.getInstance().hasVisualChanges = false
    }

    @Test
    fun checkAppCatalog() {
        Wait.waitView(ViewMatchers.withId(R.id.menuIV))

        client.sauceVisualCheck("Startup")

        Espresso.onView(ViewMatchers.withId(R.id.menuIV))
            .perform(ViewActions.click())

        Wait.waitView(ViewMatchers.withId(R.id.menuRV))

        Espresso.onView(ViewMatchers.withId(R.id.menuRV))
            .perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(10))
            .perform(
                RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                    10,
                    SideNavClickAction()
                )
            )

        val visualCheck = InstrumentationRegistry.getArguments().getString("visualCheck", "")
        val name = if (TextUtils.isEmpty(visualCheck)) "bod@example.com" else "visual@example.com"
        val pass = "10203040"

        Wait.waitView(ViewMatchers.withId(R.id.menuRV))

        // enter a name
        Espresso.onView(ViewMatchers.withId(R.id.nameET))
            .perform(ViewActions.typeText(name), ViewActions.closeSoftKeyboard())
        Espresso.onView(ViewMatchers.withId(R.id.passwordET))
            .perform(ViewActions.typeText(pass), ViewActions.closeSoftKeyboard())

        Espresso.onView(ViewMatchers.withId(R.id.nameET))
            .check(ViewAssertions.matches(ViewMatchers.withText(name)))
        Espresso.onView(ViewMatchers.withId(R.id.passwordET))
            .check(ViewAssertions.matches(ViewMatchers.withText(pass)))

        Espresso.onView(ViewMatchers.withId(R.id.loginBtn))
            .perform(scroll)
            .perform(ViewActions.click())

        Wait.waitView(ViewMatchers.withId(R.id.menuIV))

        client.sauceVisualCheck(
            "App Catalog", VisualCheckOptions.builder()
                .ignore( // Ignore any changes on the first image
                    AllOf.allOf(
                        ViewMatchers.withParentIndex(0),  // Get the first element in ViewGroup (an image)
                        ViewMatchers.withParent(
                            AllOf.allOf(
                                ViewMatchers.withParentIndex(0),  // Get the first element in RV (a ViewGroup)
                                ViewMatchers.withParent(ViewMatchers.withId(R.id.productRV))
                            )
                        )
                    )
                )
                .build()
        )

        Espresso.onView(ViewMatchers.withId(R.id.menuIV))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }

    @Test
    fun captureOnlyAppCatalog() {
        Wait.waitView(ViewMatchers.withId(R.id.menuIV))
        client.sauceVisualCheck(
            "Catalog Fragment", VisualCheckOptions.builder()
                .clipElement(ViewMatchers.withId(R.id.scrollView))
                .build()
        )
    }

    companion object {
        var client: VisualClient =
            VisualClient.builder(BuildConfig.SAUCE_USERNAME, BuildConfig.SAUCE_ACCESS_KEY)
                .buildName("My Demo App")
                .build()



    }
}
