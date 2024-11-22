package com.saucelabs.mydemoapp.android.pages

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.ViewInteraction
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import com.saucelabs.mydemoapp.android.R
import com.saucelabs.mydemoapp.android.actions.ViewActions
import com.saucelabs.mydemoapp.android.actions.Wait
import com.saucelabs.mydemoapp.android.constants.PageConstants
import com.saucelabs.mydemoapp.android.constants.ScreenshotName
import okhttp3.internal.wait
import org.junit.Assert

class MyCartPage {

    private val handleView = ViewActions()


    private val noItemTitleText: ViewInteraction = onView(withId(R.id.noItemTitleTV))
    private val goToShoppingButton: ViewInteraction = onView(withId(R.id.shoppingBt))

    private val myCartTitleText: ViewInteraction = onView(withId(R.id.productTV))
    private val productRV: ViewInteraction = onView(withId(R.id.productRV))
    private val productImage: ViewInteraction = onView(withId(R.id.productIV))
    private val productTitle: ViewInteraction = onView(withId(R.id.titleTV))
    private val priceText: ViewInteraction = onView(withId(R.id.priceTV))
    private val rattingV: ViewInteraction = onView(withId(R.id.rattingV))
    private val colorTitle: ViewInteraction = onView(withId(R.id.colorTitleTV))
    private val colorImage: ViewInteraction = onView(withId(R.id.colorIV))
    private val minusImage: ViewInteraction = onView(withId(R.id.minusIV))
    private val plusImage: ViewInteraction = onView(withId(R.id.plusIV))
    private val noTV: ViewInteraction = onView(withId(R.id.noTV))
    private val removeItemButton: ViewInteraction = onView(withId(R.id.removeBt))
    private val itemText: ViewInteraction = onView(withText(R.id.itemsTV))
    private val totalPriceText: ViewInteraction = onView(withText(R.id.totalPriceTV))
    private val proceedToCheckOutButton: ViewInteraction = onView(withId(R.id.cartBt))


    fun waitForMyCartTitle(){
        Wait.waitView(myCartTitleText)
    }
    fun waitForNoItemTitle(){
        Wait.waitView(noItemTitleText)
    }

    fun clickOnProceedToCheckOut(){
        handleView.performClick(proceedToCheckOutButton)
        Screenshot.takeScreenShot(ScreenshotName.SHIPPING_ADDRESS)
    }
   fun clickOnRemoveItemButton(){
        handleView.performClick(removeItemButton)
    }
    fun isGoShoppingButtonDisplayed(){
        handleView .isViewTextDisplayed(goToShoppingButton,PageConstants.GO_SHOPPING)
    }
    fun isCartEmptyMessageDisplayed(){
        handleView .isViewTextDisplayed(PageConstants.CART_EMPTY)
    }
    fun noItemsTextDisplayed(){
        handleView.isViewTextDisplayed(noItemTitleText,PageConstants.NO_ITEMS)
    }
    private fun verifyProceedToCheckOutButtonIsDisplayed(){
      Assert.assertTrue("Proceed To Checkout Button is Enabled",handleView.isViewEnabled(proceedToCheckOutButton))
   }
    private fun verifyGoShoppingButtonEnabled(){
        Assert.assertTrue("Go Shopping Button is Disabled",handleView.isViewEnabled(goToShoppingButton))
    }

    fun emptyMyCartUIVerification(){
        noItemsTextDisplayed()
        isCartEmptyMessageDisplayed()
        isGoShoppingButtonDisplayed()
        verifyGoShoppingButtonEnabled()
        verifyProceedToCheckOutButtonIsDisplayed()
        Screenshot.takeScreenShot(ScreenshotName.EMPTY_CART)
    }
}