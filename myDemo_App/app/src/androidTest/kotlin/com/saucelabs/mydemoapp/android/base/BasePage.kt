package com.saucelabs.mydemoapp.android.base

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.ViewInteraction
import androidx.test.espresso.matcher.ViewMatchers.withId
import com.saucelabs.mydemoapp.android.R
import com.saucelabs.mydemoapp.android.pageObjects.Helper.ViewActionsHelper
import com.saucelabs.mydemoapp.android.util.Wait

//import com.saucelabs.mydemoapp.android.pageObjects.Helper.ViewActions
//import com.saucelabs.mydemoapp.android.pageObjects.Helper.Wait

open class BasePage {

    private val viewActionHelper = ViewActionsHelper()

    private val menuIV: ViewInteraction = onView(withId(R.id.menuIV))
    private val sortIV: ViewInteraction = onView(withId(R.id.sortIV))
    private val cartRL: ViewInteraction = onView(withId(R.id.cartRL))


    fun clickOnSortButton() {
        viewActionHelper.performClick(sortIV)
    }
    fun clickCart(){
        try {
            viewActionHelper.performClick(cartRL)
        }catch (e: Exception){
            e.message
        }
    }
    fun clickMenu() {
        Wait.waitFOrView(menuIV)
        viewActionHelper.performClick(menuIV)
    }
}