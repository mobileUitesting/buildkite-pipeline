package com.saucelabs.mydemoapp.android.pageObjects

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.ViewInteraction
import androidx.test.espresso.matcher.ViewMatchers.withId
import com.saucelabs.mydemoapp.android.R
import com.saucelabs.mydemoapp.android.base.BasePage
import com.saucelabs.mydemoapp.android.pageObjects.Helper.ViewActions
import com.saucelabs.mydemoapp.android.constants.AppConstants
import com.saucelabs.mydemoapp.android.pageObjects.Helper.Wait

class SideBarMenuPage :BasePage() {

    private val handleView = ViewActions()

    private  val  menuIV: ViewInteraction = onView(withId(R.id.menuIV))
    private  val  menuRV: ViewInteraction = onView(withId(R.id.menuRV))
    private  val  itemTV: ViewInteraction = onView(withId(R.id.itemTV))

    fun navigateToLoginPage(){
        clickMenu()
        waitForMenuDisplay()
        selectMenuItem(AppConstants.LOGIN)
    }
    fun waitForMenuDisplay(){
        Wait.waitView(menuRV)
    }
    private fun selectMenuItem(menuItem:String){
        handleView.clickRecyclerViewItemWithText(menuRV,menuItem)
    }
    fun logOut(){
        clickMenu()
       selectMenuItem(AppConstants.LOG_OUT)
       handleView.performClick(AppConstants.LOG_OUT)

    }


}