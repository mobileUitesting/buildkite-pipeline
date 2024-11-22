package com.saucelabs.mydemoapp.android.actions

import android.view.WindowManager
import androidx.test.espresso.Root
import org.hamcrest.Description
import org.hamcrest.TypeSafeMatcher

class ToastMatcher : TypeSafeMatcher<Root>() {
    override fun matchesSafely(item: Root): Boolean {
        val type = item.windowLayoutParams.get().type
        if ((type == WindowManager.LayoutParams.TYPE_TOAST )) {
            val windowToken = item.decorView.windowToken
            val appToken = item.decorView.applicationWindowToken
             if (windowToken === appToken) {
                //means this window isn't contained by any other windows.
                 return true
            }
        }
        return false
    }

    override fun describeTo(description: Description) {
        description.appendText("is Toast")
    }
}

