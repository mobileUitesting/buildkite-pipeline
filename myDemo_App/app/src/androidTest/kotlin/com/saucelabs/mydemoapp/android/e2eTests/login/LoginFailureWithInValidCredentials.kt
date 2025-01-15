package com.saucelabs.mydemoapp.android.e2eTests.login

import android.util.Log
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withText
import com.saucelabs.mydemoapp.android.Config.TAG
import com.saucelabs.mydemoapp.android.pageObjects.Helper.LoginPage
import com.saucelabs.mydemoapp.android.base.BaseTest
import com.saucelabs.mydemoapp.android.data.model.UserCredentials
import com.saucelabs.mydemoapp.android.data.DataBinder
import com.saucelabs.mydemoapp.android.view.activities.SplashActivity
import kotlin.test.Test

class LoginFailureWithInValidCredentials : BaseTest<SplashActivity>(SplashActivity::class.java) {

    private val loginPage = LoginPage()


    private val userCredentials: UserCredentials = DataBinder().getUserCredentials()

    @Test
    fun loginWithInValidCredentials() {
        Log.d(TAG, "Starting test for valid login")
    loginPage.loginWithInvalidCredentials(userCredentials)
        Log.d(TAG, "Clicked on login button")
        onView(withText("Invalid email or password")).check(matches(isDisplayed()))
        Log.w(TAG, "Login failed as expected")
    }

    @Test
    fun loginLockedWithCredentials()
    {
        Log.d(TAG, "Starting test for valid login")
        loginPage.loginlocked(userCredentials)
        Log.d(TAG, "Clicked on login button")
    }
    @Test
    fun userLockedWithCredentials()
    {
        Log.d(TAG, "Starting test for valid login")
        loginPage.userLockedWithCredentials(userCredentials)
        Log.d(TAG, "Clicked on login button")
    }

}
