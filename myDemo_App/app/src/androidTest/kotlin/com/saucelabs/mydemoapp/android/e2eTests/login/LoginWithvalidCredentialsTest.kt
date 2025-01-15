package com.saucelabs.mydemoapp.android.e2eTests.login


import com.saucelabs.mydemoapp.android.pageObjects.Helper.LoginPage
import com.saucelabs.mydemoapp.android.base.BaseTest
import com.saucelabs.mydemoapp.android.data.model.UserCredentials
import com.saucelabs.mydemoapp.android.pageObjects.Helper.HomePage
import com.saucelabs.mydemoapp.android.pageObjects.Helper.ViewActionsHelper
import com.saucelabs.mydemoapp.android.data.DataBinder
import com.saucelabs.mydemoapp.android.view.activities.SplashActivity
import org.junit.Assert.assertTrue
import org.junit.Test
import kotlin.test.fail
import android.util.Log
import com.saucelabs.mydemoapp.android.Config.TAG
import org.junit.After
import org.junit.Before


class LoginWithValidCredentialsTest : BaseTest<SplashActivity>(SplashActivity::class.java) {

    private val loginPage = LoginPage()
    private val homePage = HomePage()
    private val viewActionsHelper = ViewActionsHelper()

    private val userCredentials: UserCredentials = DataBinder().getUserCredentials()

    @Before
    override fun setUp() {
        Log.d(TAG, "Setting up test environment for login functionality")

        @Test
        fun loginWithValidCredentials() {
            try {
                Log.d(TAG, "Starting test for valid login")
                loginPage.login(userCredentials)
                Log.d(TAG, "Clicked on login button")
                assertTrue(
                    "Login failed: Product text is not displayed",
                    homePage.isProductTextDisplayed()
                )
                Log.i(TAG, "Login successful, home page displayed")
            } catch (e: Exception) {
                // Handle unexpected exceptions and fail the test
                fail("Test failed due to an unexpected exception: ${e.message}")
            }
        }

        @After
        fun tearDown() {
            Log.d(TAG, "Tearing down test environment for login functionality")
            // Clean up or reset state
        }
    }
}
