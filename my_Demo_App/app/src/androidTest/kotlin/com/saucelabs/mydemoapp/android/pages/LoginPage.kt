package com.saucelabs.mydemoapp.android.pages

import android.util.Log
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.ViewAction
import androidx.test.espresso.ViewInteraction
import androidx.test.espresso.matcher.ViewMatchers.withId
import com.saucelabs.mydemoapp.android.R
import com.saucelabs.mydemoapp.android.actions.NestingAwareScrollAction
import com.saucelabs.mydemoapp.android.actions.ViewActions
import com.saucelabs.mydemoapp.android.constants.ScreenshotName

class LoginPage {
    private val handleView = ViewActions()
    private val menu = MenuHeaderLayout()
    private val scroll: ViewAction = NestingAwareScrollAction()

    private  val  loginButton: ViewInteraction = onView(withId(R.id.loginBtn))
    private  val  userName: ViewInteraction = onView(withId(R.id.nameET))
    private  val  password: ViewInteraction = onView(withId(R.id.passwordET))
    private  val  menuIV: ViewInteraction = onView(withId(R.id.menuIV))


    fun login(userEmail:String,password:String){
       menu.navigateToLoginPage()
       userLogin(userEmail,password)
    }
    fun userLogin(userEmail:String,password:String){
        enterUserName(userEmail)
        enterPassword(password)
        Screenshot.takeScreenShot(ScreenshotName.LOGIN_CREDENTIALS)
        clickLoginButton()
        }
   private fun enterUserName(username:String) {
        handleView.performTypeText(userName,username)
    }

    private fun enterPassword(userPass:String) {
        handleView.performTypeText(password,userPass)
    }

    private fun clickLoginButton() {
        loginButton.perform(scroll)
        handleView.performClick(loginButton)
    }
}