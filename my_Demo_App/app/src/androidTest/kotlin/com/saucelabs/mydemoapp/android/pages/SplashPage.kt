package com.saucelabs.mydemoapp.android.pages

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.ViewInteraction
import androidx.test.espresso.matcher.ViewMatchers.withId
import com.saucelabs.mydemoapp.android.R

class SplashPage {
              private val searchIcon: ViewInteraction = onView(withId(R.id.splashIV))
}