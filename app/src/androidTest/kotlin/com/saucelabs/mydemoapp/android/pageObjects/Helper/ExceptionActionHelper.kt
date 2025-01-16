package com.saucelabs.mydemoapp.android.pageObjects.Helper


import android.util.Log
import androidx.test.espresso.EspressoException
import androidx.test.espresso.NoMatchingViewException
import androidx.test.espresso.PerformException
import androidx.test.espresso.ViewAction
import androidx.test.espresso.ViewInteraction
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId

object EspressoActionHelper {

    private const val TAG = "EspressoActionHelper"


    fun performAction(viewId: Int, action: ViewAction): Boolean {
        return try {
            val viewInteraction: ViewInteraction = onView(withId(viewId))
            viewInteraction.perform(action)
            true
        } catch (e: NoMatchingViewException) {
            Log.e(TAG, "No matching view found with ID: $viewId", e)
            false
        } catch (e: PerformException) {
            Log.e(TAG, "Failed to perform action on view with ID: $viewId", e)
            false
//            } catch (e: EspressoException) {
//                Log.e(TAG, "Espresso encountered an error with view ID: $viewId", e)
//                false
        } catch (e: Exception) {
            Log.e(TAG, "Unexpected error performing action on view ID: $viewId", e)
            false
        }
    }

    fun doesViewExist(viewId: Int): Boolean {
        return try {
            onView(withId(viewId)).check(matches(ViewMatchers.isDisplayed()))
            true
        } catch (e: NoMatchingViewException) {
            Log.w(TAG, "View with ID: $viewId does not exist.")
            false
        }
    }
}

