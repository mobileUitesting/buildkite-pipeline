package com.saucelabs.mydemoapp.android.pages

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.ViewInteraction
import androidx.test.espresso.matcher.ViewMatchers.withId
import com.saucelabs.mydemoapp.android.R
import com.saucelabs.mydemoapp.android.actions.ViewActions
import com.saucelabs.mydemoapp.android.actions.Wait
import com.saucelabs.mydemoapp.android.constants.PageConstants
import com.saucelabs.mydemoapp.android.constants.ScreenshotName

class SortDialogPage {

    private val handleView = ViewActions()
    private val menu = MenuHeaderLayout()

    private  val  sortByText: ViewInteraction = onView(withId(R.id.sortTV))
    private  val  tickNameAscImage: ViewInteraction = onView(withId(R.id.tickNameAscIV))
    private  val  menuNameAscImage: ViewInteraction = onView(withId(R.id.menuNameAscIV))
    private  val  tickNameDesImage: ViewInteraction = onView(withId(R.id.tickNameDesIV))
    private  val  menuNameDesImage: ViewInteraction = onView(withId(R.id.menuNameDesIV))

    private  val  tickPriceAscImage: ViewInteraction = onView(withId(R.id.tickPriceAscIV))
    private  val  menuPriceAscImage: ViewInteraction = onView(withId(R.id.menuPriceAscIV))
    private  val  tickPriceDscImage: ViewInteraction = onView(withId(R.id.tickPriceDscIV))
    private  val  menuPriceDscImage: ViewInteraction = onView(withId(R.id.menuPriceDscIV))


    fun performSortingByText(sortText:String){
        menu.clickOnSortButton()
        waitForSortDialogDisplay()
        Screenshot.takeScreenShot(ScreenshotName.SORT)
        handleView.performClick(sortText)
        menu.waitForMenu()

    }

    fun isSortDialogPageDisplayed(sortByText:String):Boolean{
        return handleView.isViewTextDisplayed(sortByText)
    }
    fun waitForSortDialogDisplay(){
        Wait.waitView(sortByText)
    }

}