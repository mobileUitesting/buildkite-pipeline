package com.saucelabs.mydemoapp.android.pageObjects.Helper


import android.util.Log
import com.saucelabs.mydemoapp.android.Config.TAG
import com.saucelabs.mydemoapp.android.base.BaseTest
import com.saucelabs.mydemoapp.android.data.model.UserCredentials
import com.saucelabs.mydemoapp.android.data.DataBinder
import com.saucelabs.mydemoapp.android.pageObjects.LoginPage
import com.saucelabs.mydemoapp.android.pageObjects.LogoutPage
import com.saucelabs.mydemoapp.android.utils.annotations.Regression
import com.saucelabs.mydemoapp.android.view.activities.SplashActivity
import io.qameta.allure.kotlin.junit4.Tag
import org.junit.After
import org.junit.Assert.fail
import org.junit.Before
import kotlin.test.Test

open class LogoutTest : BaseTest<SplashActivity>(SplashActivity::class.java) {

    private val userCredentials: UserCredentials = DataBinder().getUserCredentials()
    private val logoutPage = LogoutPage()
    private val loginPage = LoginPage()

    @Regression
    @Tag("regression")
    @Test
    fun testLogoutFunctionality() {

        try {

            loginPage.login(userCredentials)
            logoutPage.logout()

        } catch (e: Exception) {
            fail("Test failed due to an unexpected exception: ${e.message}")
        }
    }

}


