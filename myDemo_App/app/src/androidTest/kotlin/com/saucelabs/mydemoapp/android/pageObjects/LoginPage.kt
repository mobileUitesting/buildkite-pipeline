package com.saucelabs.mydemoapp.android.pageObjects


import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.ViewInteraction
import androidx.test.espresso.action.ViewActions.closeSoftKeyboard
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.matcher.ViewMatchers
import com.saucelabs.mydemoapp.android.R
import com.saucelabs.mydemoapp.android.data.model.UserCredentials
import com.saucelabs.mydemoapp.android.pageObjects.Helper.SideMenuPage
import com.saucelabs.mydemoapp.android.pageObjects.Helper.ViewActionsHelper



class LoginPage {

    private val viewActionsHelper = ViewActionsHelper()
    private val sideMenu = SideMenuPage()



    private val userEmail: ViewInteraction = onView(ViewMatchers.withId(R.id.nameET))
    private val userPassword: ViewInteraction = onView(ViewMatchers.withId(R.id.passwordET))
    private val loginButton: ViewInteraction = onView(ViewMatchers.withId(R.id.loginBtn))


    private fun userLogin(userCredentials: UserCredentials) {


        userEmail.perform(typeText(userCredentials.userEmail), closeSoftKeyboard())

        userPassword.perform(typeText(userCredentials.userPassword), closeSoftKeyboard())

    }

    fun login(userCredentials: UserCredentials) {
        sideMenu.navigateToLoginPage()
        userLogin(userCredentials)
        viewActionsHelper.performClick(loginButton)

    }
}



