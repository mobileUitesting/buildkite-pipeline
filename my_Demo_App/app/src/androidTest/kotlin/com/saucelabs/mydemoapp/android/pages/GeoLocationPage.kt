package com.saucelabs.mydemoapp.android.pages

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.ViewInteraction
import androidx.test.espresso.matcher.ViewMatchers.withId
import com.saucelabs.mydemoapp.android.R
import com.saucelabs.mydemoapp.android.actions.ViewActions

class GeoLocationPage {

    private val handleView = ViewActions()

    private val webViewTV: ViewInteraction = onView(withId(R.id.webViewTV))
    private val urlTV: ViewInteraction = onView(withId(R.id.urlTV))
    private val urlET: ViewInteraction = onView(withId(R.id.urlET))
    private val enterTV: ViewInteraction = onView(withId(R.id.enterTV))
    private val goBtn: ViewInteraction = onView(withId(R.id.goBtn))

}