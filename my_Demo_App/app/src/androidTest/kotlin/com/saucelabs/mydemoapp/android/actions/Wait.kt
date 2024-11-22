package com.saucelabs.mydemoapp.android.actions

import android.view.View
import androidx.test.espresso.Espresso
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.UiController
import androidx.test.espresso.ViewAction
import androidx.test.espresso.ViewInteraction
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.isRoot
import androidx.test.espresso.matcher.ViewMatchers.withText
import org.hamcrest.Matcher

class Wait() {

    companion object{

        fun waitView(viewMatcher: Matcher<View>) {
           val millis:Long = 2000
            waitView(viewMatcher, millis)
        }

     private fun waitView(viewMatcher: Matcher<View>, millis: Long) {
        val start = System.currentTimeMillis()
        while (System.currentTimeMillis() - start <= millis) {
            try {
                Espresso.onView(viewMatcher)
                    .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
                break
            } catch (t: Throwable) {
            }

            try {
                Thread.sleep(500)
            } catch (e: InterruptedException) {
                throw RuntimeException(e)
            }
        }
    }

    fun waitView(viewId:ViewInteraction) {
            val millis:Long = 2000
            waitView(viewId, millis)
    }

    fun waitView(viewId:ViewInteraction, millis: Long) {
            val start = System.currentTimeMillis()
            while (System.currentTimeMillis() - start <= millis) {
                try {
                    viewId.check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
                    break
                } catch (t: Throwable) {
                }

                try {
                    Thread.sleep(500)
                } catch (e: InterruptedException) {
                    throw RuntimeException(e)
                }
            }
        }

        fun waitViewText(viewText:String) {
            val millis:Long = 2000
            waitViewText(viewText, millis)
        }


        fun waitViewText(viewText:String, millis: Long) {
            val start = System.currentTimeMillis()
            while (System.currentTimeMillis() - start <= millis) {
                try {
                    onView(withText(viewText)).check(matches(isDisplayed()))
                    break
                } catch (t: Throwable) {
                }

                try {
                    Thread.sleep(500)
                } catch (e: InterruptedException) {
                    throw RuntimeException(e)
                }
            }
        }



        fun waitForToast(millis: Long): ViewAction {
            return object : ViewAction {
                override fun getConstraints(): Matcher<View> {
                    return isRoot()
                }

                override fun getDescription(): String {
                    return "Wait for a toast message for $millis milliseconds."
                }

                override fun perform(uiController: UiController, view: View?) {
                    uiController.loopMainThreadForAtLeast(millis)
                }
            }
        }

        fun waitView(myProfile: String, i: Int) {

        }

    }
}