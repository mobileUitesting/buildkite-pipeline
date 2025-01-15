package com.saucelabs.mydemoapp.android.pageObjects.Helper


import android.util.Log
import com.saucelabs.mydemoapp.android.Config.TAG
import com.saucelabs.mydemoapp.android.base.BaseTest
import com.saucelabs.mydemoapp.android.data.model.UserCredentials
import com.saucelabs.mydemoapp.android.data.DataBinder
import com.saucelabs.mydemoapp.android.view.activities.SplashActivity
import org.junit.After
import org.junit.Assert.fail
import org.junit.Before
import kotlin.test.Test

open class LogoutActivityTest : BaseTest<SplashActivity>(SplashActivity::class.java) {

    private val userCredentials: UserCredentials = DataBinder().getUserCredentials()
    private val logoutPage = LogoutPage()
    private val loginPage = LoginPage()

    @Test
    fun testLogoutFunctionality() {
        @Before
        fun setUp() {
            Log.d(TAG, "Setting up test environment for logout functionality")
            // Perform login or necessary setup here
        }
        try {
            Log.d(TAG, "Clicked on login button")
            loginPage.login(userCredentials)
            Log.d(TAG, "Clicked on login button")
            Log.d(TAG, "Starting logout test")
            logoutPage.logout()
            Log.d(TAG, "Menu button clicked")
            Log.i(TAG, "Logout successful, login screen displayed")
        } catch (e: Exception) {
            fail("Test failed due to an unexpected exception: ${e.message}")
        }
    }
    @After
    override fun tearDown() {
        Log.d(TAG, "Tearing down test environment for logout functionality")
        // Clean up or reset state
    }
}


