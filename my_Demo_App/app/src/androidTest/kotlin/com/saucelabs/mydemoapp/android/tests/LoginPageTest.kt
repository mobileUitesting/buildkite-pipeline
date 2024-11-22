package com.saucelabs.mydemoapp.android.tests

import androidx.test.espresso.Espresso
import androidx.test.espresso.ViewAction
import com.saucelabs.mydemoapp.android.actions.NestingAwareScrollAction
import com.saucelabs.mydemoapp.android.base.BaseTest
import com.saucelabs.mydemoapp.android.base.ErrorFlow
import com.saucelabs.mydemoapp.android.base.HappyFlow
import com.saucelabs.mydemoapp.android.constants.ErrorMessage
import com.saucelabs.mydemoapp.android.constants.ScreenshotName
import com.saucelabs.mydemoapp.android.data.DataLoader
import com.saucelabs.mydemoapp.android.data.model.UserCredentials
import com.saucelabs.mydemoapp.android.pages.LoginPage
import com.saucelabs.mydemoapp.android.pages.MenuHeaderLayout
import com.saucelabs.mydemoapp.android.utils.SingletonClass
import com.saucelabs.mydemoapp.android.view.activities.SplashActivity
import org.junit.Assert
import org.junit.Before
import org.junit.Test


class LoginPageTest : BaseTest<SplashActivity>(SplashActivity::class.java) {
    //This ViewAction For Nested ScrollView
    private val scroll: ViewAction = NestingAwareScrollAction()
    private val menu = MenuHeaderLayout()
    private val login = LoginPage()
    private val handleView = com.saucelabs.mydemoapp.android.actions.ViewActions()
    private val userCredentials: UserCredentials = DataLoader().getLoginCredentials()



    @Before
    fun removeLogin() {
        SingletonClass.getInstance().isLogin = false
        SingletonClass.getInstance().hasVisualChanges = false
    }

    @Test
    @ErrorFlow
    fun noCredentialLoginTest() {
        login.login("","")
        Assert.assertTrue(handleView.isViewTextDisplayed(ErrorMessage.USERNAME_REQUIRED))
        Screenshot.takeScreenShot(ScreenshotName.USERNAME_REQUIRED)
        Espresso.pressBack()
        menu.waitForMenu()
        Assert.assertTrue(menu.isMenuDisplayed())
    }

    @Test
    @ErrorFlow
    fun noUsernameLoginTest() {
        login.login("",userCredentials.userPassword)
        Assert.assertTrue(handleView.isViewTextDisplayed(ErrorMessage.USERNAME_REQUIRED))
        Screenshot.takeScreenShot(ScreenshotName.USERNAME_REQUIRED)
        Espresso.pressBack()
        menu.waitForMenu()
        Assert.assertTrue(menu.isMenuDisplayed())
    }

    @Test
    @ErrorFlow
    fun noPasswordLoginTest() {
        login.login(userCredentials.userEmail,"")
        Assert.assertTrue(handleView.isViewTextDisplayed(ErrorMessage.ENTER_PASSWORD))
        Screenshot.takeScreenShot(ScreenshotName.PASSWORD_REQUIRED)
        Espresso.pressBack()
        menu.waitForMenu()
        Assert.assertTrue(menu.isMenuDisplayed())
    }

    @Test
    @HappyFlow
    fun successfulLoginTest() {
       login.login(userCredentials.userEmail,userCredentials.userPassword)
        Screenshot.takeScreenShot(ScreenshotName.HOME_PAGE)
        menu.waitForMenu()
       Assert.assertTrue(menu.isMenuDisplayed())

    }
}
