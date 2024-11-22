package com.saucelabs.mydemoapp.android.actions

import android.view.View
import androidx.test.espresso.Root
import org.hamcrest.Description
import org.hamcrest.Matcher
import org.hamcrest.TypeSafeMatcher

fun isSnackBar(): Matcher<Root> {
    return object : TypeSafeMatcher<Root>(), Matcher<Root> {
        override fun describeTo(description: Description) {
            description.appendText("is SnackBar")
        }
        override fun matchesSafely(root: Root): Boolean {
            val view: View? = root.decorView.findViewById(com.google.android.material.R.id.snackbar_text)
            return view != null && view.isShown
        }
    }
}