package com.saucelabs.mydemoapp.android.base

import android.app.Activity
import android.content.Context
import androidx.test.core.app.ApplicationProvider
import androidx.test.espresso.intent.Intents
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.uiautomator.UiDevice
import com.saucelabs.mydemoapp.android.utils.Logger
import com.saucelabs.mydemoapp.android.sessionmanager.SessionManager
import io.qameta.allure.android.rules.LogcatRule
import io.qameta.allure.android.rules.ScreenshotRule
import io.qameta.allure.android.rules.WindowHierarchyRule
import io.qameta.allure.android.runners.AllureAndroidJUnit4
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.rules.RuleChain
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
open class BaseTest<T : Activity>(activityClass: Class<T>){


    @get:Rule
    var rule = ActivityScenarioRule(activityClass)

    protected lateinit var context: Context
    protected lateinit var  sessionManager: SessionManager
     @Before
    open fun setUp() {
         disableAnimations()
      //  IdlingRegistry.getInstance().register(mIdlingResource)
       Logger.initialize()
        Intents.init()
         context = InstrumentationRegistry.getInstrumentation().context
         sessionManager = SessionManager(context)
         sessionManager.setupSession("fake_auth_token")

    }

    @After
    open fun tearDown() {
        Intents.release()
         context = InstrumentationRegistry.getInstrumentation().targetContext
        val sessionManager = SessionManager(context)
        sessionManager.clearSession()
    }


    private fun disableAnimations() {
        UiDevice.getInstance(InstrumentationRegistry.getInstrumentation()).apply {
            executeShellCommand("settings put global animator_duration_scale 0")
            executeShellCommand("settings put global transition_animation_scale 0")
            executeShellCommand("settings put global window_animation_scale 0")
        }
    }
}



