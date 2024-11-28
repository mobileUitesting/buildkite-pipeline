package com.saucelabs.mydemoapp.android.pageObjects

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.ViewAction
import androidx.test.espresso.ViewInteraction
import androidx.test.espresso.matcher.ViewMatchers.withId
import com.saucelabs.mydemoapp.android.R
import com.saucelabs.mydemoapp.android.pageObjects.Helper.NestingAwareScrollAction
import com.saucelabs.mydemoapp.android.pageObjects.Helper.ViewActions

class LoginPage {
    private val handleView = ViewActions()
    private val menu = SideBarMenuPage()
    private val scroll: ViewAction = NestingAwareScrollAction()

    private  val  loginText: ViewInteraction = onView(withId(R.id.loginTV))
    private  val  loginButton: ViewInteraction = onView(withId(R.id.loginBtn))
    private  val  userName: ViewInteraction = onView(withId(R.id.nameET))
    private  val  password: ViewInteraction = onView(withId(R.id.passwordET))
    private  val  menuIV: ViewInteraction = onView(withId(R.id.menuIV))

    private  val  emailError: ViewInteraction = onView(withId(R.id.nameErrorTV))
    private  val  passwordError: ViewInteraction = onView(withId(R.id.passwordErrorTV))

    fun login(userEmail:String,password:String){
       menu.navigateToLoginPage()
       userLogin(userEmail,password)
    }
    fun userLogin(userEmail:String, userPassword:String){
        handleView.performTypeText(userName,userEmail)
        handleView.performTypeText(password,userPassword)
        loginButton.perform(scroll)
        handleView.performClick(loginButton)
        }
    fun getUserEmailErrorText():String{
        return handleView.getText(emailError)
    }
    fun getPasswordErrorText():String{
        return handleView.getText(passwordError)
    }
    fun getLoginText():String{
        return handleView.getText(loginText)
    }
    fun getEmailError():String{
        return handleView.getText(emailError)
    }
    fun getPasswordError():String{
        return handleView.getText(passwordError)
    }
}