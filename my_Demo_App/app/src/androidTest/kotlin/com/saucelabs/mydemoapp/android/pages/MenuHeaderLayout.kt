package com.saucelabs.mydemoapp.android.pages

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.ViewAction
import androidx.test.espresso.ViewInteraction
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import com.saucelabs.mydemoapp.android.R
import com.saucelabs.mydemoapp.android.actions.SideNavClickAction
import com.saucelabs.mydemoapp.android.actions.ViewActions
import com.saucelabs.mydemoapp.android.actions.Wait
import com.saucelabs.mydemoapp.android.constants.ScreenshotName

class MenuHeaderLayout {

    private val handleView = ViewActions()
    private val myCart=MyCartPage()

    private  val  menuIV: ViewInteraction = onView(withId(R.id.menuIV))
    private  val  sortIV: ViewInteraction = onView(withId(R.id.sortIV))
    private  val  cartRL: ViewInteraction = onView(withId(R.id.cartRL))
    private  val  cartIV: ViewInteraction = onView(withId(R.id.cartIV))
    private  val  cartTV: ViewInteraction = onView(withId(R.id.cartTV))
    private  val  mvDemoTitle: ViewInteraction = onView(withId(R.id.mTvTitle))
    private  val  menuRV: ViewInteraction = onView(withId(R.id.menuRV))
    private  val  itemTV: ViewInteraction = onView(withId(R.id.itemTV))




    fun navigateToLoginPage(){
        waitForMenu()
        clickOnMenu()
        Screenshot.takeScreenShot(ScreenshotName.MENU)
        waitForMenuDisplay()
        clickOnMenuItem(10)
        Screenshot.takeScreenShot(ScreenshotName.LOGIN_PAGE)
    }

    fun clickOnMenu(){
        handleView.performClick(menuIV)
    }
    fun clickOnMenuItem(position:Int){
        handleView.recyclerActionOnItemAtPosition(menuRV,position, SideNavClickAction())
        Screenshot.takeScreenShot(ScreenshotName.MENU)
    }

    fun clickOnSortButton(){
        handleView.performClick(sortIV)
    }

    fun isMenuDisplayed():Boolean{
      return  handleView.isViewDisplayed(menuIV)
    }
    fun waitForMenu(){
        Wait.waitView(menuIV)
    }

    fun waitForMenuDisplay(){
        Wait.waitView(menuRV)
    }
    fun clickOnCart(){
        myCart.waitForMyCartTitle()
        Screenshot.takeScreenShot(ScreenshotName.MYCART)
        handleView.performClick(cartRL)
    }

    fun clickOnLogOut(logout:String){
        handleView.performClick(logout)
        Screenshot.takeScreenShot(ScreenshotName.LOGIN_PAGE)
    }


}