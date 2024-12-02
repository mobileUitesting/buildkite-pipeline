package com.saucelabs.mydemoapp.android.base

import android.app.Activity
import androidx.test.core.app.ApplicationProvider
import androidx.test.espresso.intent.Intents
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.saucelabs.mydemoapp.android.utils.Logger
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
open class BaseTest<T : Activity>(activityClass: Class<T>){

    @get:Rule
    var rule = ActivityScenarioRule(activityClass)


    @Before
    open fun setUp() {
      //  IdlingRegistry.getInstance().register(mIdlingResource)
        Logger.initialize(ApplicationProvider.getApplicationContext())
        Intents.init()

    }

    @After
    fun tearDown() {
        Intents.release()
    }
 }



