package com.saucelabs.mydemoapp.android.e2eTests.login


import com.saucelabs.mydemoapp.android.pageObjects.LoginPage
import com.saucelabs.mydemoapp.android.base.BaseTest
import com.saucelabs.mydemoapp.android.view.activities.SplashActivity
import org.junit.Test




class LoginWithValidCredentialsTest : BaseTest<SplashActivity>(SplashActivity::class.java) {

    private val loginPage = LoginPage()


    @Test

    fun loginWithInValidCredentials() {


    }

    @Test
    fun loginLockedWithCredentials()
    {


    }
    @Test
    fun userLockedWithCredentials()
    {



    }

    @Test
    fun userEmptyDetails()
    {

    }
}
