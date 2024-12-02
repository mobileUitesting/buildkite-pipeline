package com.saucelabs.mydemoapp.android.pageObjects

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.ViewInteraction
import androidx.test.espresso.matcher.ViewMatchers.withId
import com.saucelabs.mydemoapp.android.R
import com.saucelabs.mydemoapp.android.pageObjects.Helper.ViewActions

class MyCartPage {

    private val handleView = ViewActions()

    private val goToShoppingButton: ViewInteraction = onView(withId(R.id.shoppingBt))
    private val proceedToCheckOutButton: ViewInteraction = onView(withId(R.id.cartBt))
    private val totalItems: ViewInteraction = onView(withId(R.id.itemsTV))
    private val productRV: ViewInteraction = onView(withId(R.id.productRV))


    fun clickProceedToCheckOut(){
        handleView.performClick(proceedToCheckOutButton)
    }
    fun getTotalNoOfItems():String{
        return handleView.getText(totalItems)
     }

    fun verifyProductName(productName:String):String{
        return handleView.getTextInRecyclerView(productRV,productName)
    }
}