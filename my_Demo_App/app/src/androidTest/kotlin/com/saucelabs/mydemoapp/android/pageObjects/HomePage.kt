package com.saucelabs.mydemoapp.android.pageObjects

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.ViewInteraction
import androidx.test.espresso.matcher.ViewMatchers.withId
import com.saucelabs.mydemoapp.android.R
import com.saucelabs.mydemoapp.android.base.BasePage
import com.saucelabs.mydemoapp.android.pageObjects.Helper.ViewActions
import com.saucelabs.mydemoapp.android.constants.AppConstants

class HomePage : BasePage() {

    private val handleView = ViewActions()


    private val productRV: ViewInteraction = onView(withId(R.id.productRV))

    fun performSortingByText(sortText:String){
        clickOnSortButton()
        handleView.performClick(sortText)
    }
    fun selectProductAtPosition(position: Int) {
        handleView.clickChildViewAtPosition(productRV, position)
    }
    fun selectProductByText(productTitle:String){
        handleView.clickRecyclerViewItemWithText(productRV,productTitle)
    }
    fun selectLowestPriceProduct(){
        performSortingByText(AppConstants.SORT_BY_PRICE_ASC)
        selectProductAtPosition(0)
    }

 }