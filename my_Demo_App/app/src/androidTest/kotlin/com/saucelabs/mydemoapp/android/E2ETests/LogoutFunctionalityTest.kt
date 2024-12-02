package com.saucelabs.mydemoapp.android.E2ETests

import com.saucelabs.mydemoapp.android.pageObjects.Helper.VerificationManager
import com.saucelabs.mydemoapp.android.base.BaseTest
import com.saucelabs.mydemoapp.android.constants.Messages
import com.saucelabs.mydemoapp.android.constants.AppConstants
import com.saucelabs.mydemoapp.android.data.DataLoader
import com.saucelabs.mydemoapp.android.data.model.LoginCredentials
import com.saucelabs.mydemoapp.android.base.BasePage
import com.saucelabs.mydemoapp.android.pageObjects.LoginPage
import com.saucelabs.mydemoapp.android.pageObjects.SideBarMenuPage
import com.saucelabs.mydemoapp.android.utils.CryptoUtils.decrypt
import com.saucelabs.mydemoapp.android.utils.SingletonClass
import com.saucelabs.mydemoapp.android.view.activities.SplashActivity
import org.junit.Before
import org.junit.Test

class LogoutFunctionalityTest : BaseTest<SplashActivity>(SplashActivity::class.java) {

    private val basePage = BasePage()
    private val loginPage = LoginPage()
    private val sideBarMenu = SideBarMenuPage()

    private val verificationManager = VerificationManager()

    private val loginCredentials: LoginCredentials = DataLoader().getLoginCredentials()

    @Before
    fun clearSession() {
        SingletonClass.getInstance().isLogin = false
        SingletonClass.getInstance().hasVisualChanges = false

    }

    /** Scenario : This is a Scenario that checks
     * → Logout functionality
     *  @params   userEmail, userPassword for Login
     */
    @Test
    fun verifyLogoutFunctionality() {
        basePage.clickMenu()
        loginPage.login(loginCredentials.userEmail, loginCredentials.userPassword)
        basePage.clickMenu()
        sideBarMenu.logOut()
        verificationManager.verifyTextAndStopTest(
        loginPage.getLoginText(), AppConstants.LOGIN_TITLE, Messages.VERIFY_LOGIN_TEXT
        )
    }

}