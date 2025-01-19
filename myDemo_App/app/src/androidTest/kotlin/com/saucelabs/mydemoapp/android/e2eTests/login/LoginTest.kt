package com.saucelabs.mydemoapp.android.e2eTests.login


import com.saucelabs.mydemoapp.android.pageObjects.LoginPage
import com.saucelabs.mydemoapp.android.base.BaseTest
import com.saucelabs.mydemoapp.android.data.model.UserCredentials
import com.saucelabs.mydemoapp.android.pageObjects.HomePage
import com.saucelabs.mydemoapp.android.pageObjects.Helper.ViewActionsHelper
import com.saucelabs.mydemoapp.android.data.DataBinder
import com.saucelabs.mydemoapp.android.utils.annotations.Regression
import com.saucelabs.mydemoapp.android.view.activities.SplashActivity
import io.qameta.allure.kotlin.junit4.Tag
import org.junit.Test
import kotlin.test.fail



class LoginTest : BaseTest<SplashActivity>(SplashActivity::class.java) {

    private val loginPage = LoginPage()
    private val homePage = HomePage()
    private val viewActionsHelper = ViewActionsHelper()

    private val userCredentials: UserCredentials = DataBinder().getUserCredentials()

        @Regression
        @Tag("regression")
        @Test
        fun loginWithValidCredentials() {
            try {

                loginPage.login(userCredentials)

                homePage.isProductTextDisplayed()

            } catch (e: Exception) {
                // Handle unexpected exceptions and fail the test
                fail("Test failed due to an unexpected exception: ${e.message}")
            }
        }

    }

