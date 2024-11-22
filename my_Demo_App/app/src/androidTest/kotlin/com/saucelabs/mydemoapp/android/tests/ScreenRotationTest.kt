package com.saucelabs.mydemoapp.android.tests

import android.content.pm.ActivityInfo
import android.content.res.Configuration
import android.os.SystemClock
import android.view.View
import androidx.test.espresso.Espresso
import androidx.test.espresso.NoMatchingViewException
import androidx.test.espresso.ViewAssertion
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.saucelabs.mydemoapp.android.R
import com.saucelabs.mydemoapp.android.actions.Wait
import com.saucelabs.mydemoapp.android.base.BaseTest
import com.saucelabs.mydemoapp.android.view.activities.MainActivity
import org.junit.Assert
import org.junit.Rule
import org.junit.Test

class ScreenRotationTest : BaseTest<MainActivity>(MainActivity::class.java){
    @Rule
    var activityRule: ActivityScenarioRule<MainActivity> = ActivityScenarioRule(
        MainActivity::class.java
    )

   @Test
    fun screenOrientationTest() {
        // Splash screen
        Wait.waitView(ViewMatchers.withId(R.id.menuIV))

        // Verify the screen orientation is portrait
        Espresso.onView(ViewMatchers.isRoot())
            .check(matchesOrientation(Configuration.ORIENTATION_PORTRAIT))

        // set screen orientation to landscape
        activityRule.scenario.onActivity { activity: MainActivity ->
            activity.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE
        }
        // Pause for 2 seconds for demo purpose
        SystemClock.sleep(2000)
        // Verify the screen orientation is landscape
        Espresso.onView(ViewMatchers.isRoot())
            .check(matchesOrientation(Configuration.ORIENTATION_LANDSCAPE))

        // set screen orientation to portrait again
        activityRule.scenario.onActivity { activity: MainActivity ->
            activity.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
        }
        // Pause for 2 seconds for demo purpose
        SystemClock.sleep(2000)
        // Verify the screen orientation is portrait
        Espresso.onView(ViewMatchers.isRoot())
            .check(matchesOrientation(Configuration.ORIENTATION_PORTRAIT))
    }

    companion object {
        fun matchesOrientation(orientation: Int): ViewAssertion {
            return ViewAssertion { view: View, noViewFoundException: NoMatchingViewException? ->
                if (noViewFoundException != null) {
                    throw noViewFoundException
                }
                val actualOrientation = view.context.resources.configuration.orientation
                Assert.assertEquals(orientation.toLong(), actualOrientation.toLong())
            }
        }
    }
}
