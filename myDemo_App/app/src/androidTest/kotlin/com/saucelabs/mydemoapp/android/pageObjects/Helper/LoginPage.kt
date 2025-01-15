package com.saucelabs.mydemoapp.android.pageObjects.Helper

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.ViewInteraction
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.closeSoftKeyboard
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.matcher.ViewMatchers
import com.saucelabs.mydemoapp.android.R
import com.saucelabs.mydemoapp.android.data.model.UserCredentials


class LoginPage {

    private val viewActionsHelper = ViewActionsHelper()

    private val menuIcon: ViewInteraction = onView(ViewMatchers.withId(R.id.menuIV))
    private val loginIcon: ViewInteraction = onView(ViewMatchers.withText("Log In"))
    private val userEmail: ViewInteraction = onView(ViewMatchers.withId(R.id.nameET))
    private val userPassword: ViewInteraction = onView(ViewMatchers.withId(R.id.passwordET))
    private val loginButton: ViewInteraction = onView(ViewMatchers.withId(R.id.loginBtn))
    private val productsText: ViewInteraction = onView(ViewMatchers.withId(R.id.productTV))
    private val productAssert: ViewInteraction = onView(ViewMatchers.withText("Products"))
    private val invalidUserEmail: ViewInteraction = onView(ViewMatchers.withId(R.id.nameET))
    private val invalidUserPassword: ViewInteraction = onView(ViewMatchers.withId(R.id.passwordET))
    private val lockedUserEmail: ViewInteraction = onView(ViewMatchers.withId(R.id.nameET))
    private val lockedUserPassword: ViewInteraction = onView(ViewMatchers.withId(R.id.passwordET))

    private fun menuClick() {
        menuIcon.perform(click())
    }

    private fun loginMenuClick() {
        loginIcon.perform(click())
    }


    private fun enterUserCredentials(userCredentials: UserCredentials) {
        userEmail.perform(typeText(userCredentials.userEmail), closeSoftKeyboard())
        userPassword.perform(typeText(userCredentials.userPassword), closeSoftKeyboard())
    }

    fun login(userCredentials: UserCredentials) {
        menuClick()
        loginMenuClick()
        enterUserCredentials(userCredentials)
        loginButton.perform(click())

    }

    fun loginFailed(userCredentials: UserCredentials) {
        invalidUserEmail.perform(typeText(userCredentials.invalidUserEmail))
        invalidUserPassword.perform(typeText(userCredentials.invalidUserPassword))

    }

    fun loginWithInvalidCredentials(userCredentials: UserCredentials) {
        menuClick()
        loginMenuClick()
        loginFailed(userCredentials)
        loginButton.perform(click())
    }

    fun loginlocked(userCredentials: UserCredentials) {
        lockedUserEmail.perform(typeText(userCredentials.lockedUserEmail))
        lockedUserPassword.perform(typeText(userCredentials.lockedUserPassword))

    }

    fun userLockedWithCredentials(userCredentials: UserCredentials) {
        menuClick()
        loginMenuClick()
        loginlocked(userCredentials)
        loginButton.perform(click())
    }


}