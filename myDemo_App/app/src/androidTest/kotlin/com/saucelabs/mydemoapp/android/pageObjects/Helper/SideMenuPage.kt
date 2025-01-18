package com.saucelabs.mydemoapp.android.pageObjects.Helper

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.ViewInteraction
import androidx.test.espresso.matcher.ViewMatchers.withId
import com.saucelabs.mydemoapp.android.R
import com.saucelabs.mydemoapp.android.base.BasePage
import com.saucelabs.mydemoapp.android.constants.AppConstants
import com.saucelabs.mydemoapp.android.util.Wait

class SideMenuPage :BasePage(){

    private  val viewActionsHelper=ViewActionsHelper()

    private val menuRV: ViewInteraction = onView(withId(R.id.menuRV))

    fun navigateToLoginPage(){
        clickMenu()
        waitFOrMenuDisplay()
        selectMenuItem(AppConstants.LOGIN)
    }
    private fun waitFOrMenuDisplay(){
        Wait.waitFOrView(menuRV)
    }

    private fun selectMenuItem(menuItem:String){
        viewActionsHelper.clickRecyclerViewItemByText(menuRV,menuItem)
    }

    fun logout(){
        clickMenu()
        selectMenuItem(AppConstants.LOG_OUT)
        viewActionsHelper.performClick(AppConstants.LOG_OUT)

    }

}