package com.saucelabs.mydemoapp.android.e2eTests.login


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

        loginPage.loginWithInvalidCredentials(userCredentials)

    }

    @Test
    fun loginLockedWithCredentials()
    {

        loginPage.loginlocked(userCredentials)

    }
    @Test
    fun userLockedWithCredentials()
    {

        loginPage.userLockedWithCredentials(userCredentials)

    }

}
