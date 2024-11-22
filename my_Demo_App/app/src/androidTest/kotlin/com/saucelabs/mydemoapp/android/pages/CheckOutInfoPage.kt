package com.saucelabs.mydemoapp.android.pages

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.ViewAction
import androidx.test.espresso.ViewInteraction
import androidx.test.espresso.matcher.ViewMatchers.withId
import com.saucelabs.mydemoapp.android.R
import com.saucelabs.mydemoapp.android.actions.NestingAwareScrollAction
import com.saucelabs.mydemoapp.android.actions.ViewActions
import com.saucelabs.mydemoapp.android.constants.ErrorMessage
import com.saucelabs.mydemoapp.android.constants.ScreenshotName
import com.saucelabs.mydemoapp.android.data.model.CheckoutInfo

class CheckOutInfoPage {
    private val handleView = ViewActions()
    private val scroll: ViewAction = NestingAwareScrollAction()
    private val menu = MenuHeaderLayout()
    private val login = LoginPage()
    private val productsCatalog = ProductCatalogPage()
    private val productsDetailsPage= ProductDetailsPage()
    private val myCart= MyCartPage()

    // Shipping Address
    private val checkoutTitleText: ViewInteraction = onView(withId(R.id.checkoutTitleTV))
    private val enterShippingAddressText: ViewInteraction = onView(withId(R.id.enterShippingAddressTV))
    private val fullNameText: ViewInteraction = onView(withId(R.id.fullNameTV))
    private val fullNameET: ViewInteraction = onView(withId(R.id.fullNameET))
    private val address1Text: ViewInteraction = onView(withId(R.id.address1TV))
    private val address1ET: ViewInteraction = onView(withId(R.id.address1ET))
    private val address2Text: ViewInteraction = onView(withId(R.id.address2TV))
    private val address2ET: ViewInteraction = onView(withId(R.id.address2ET))
    private val cityText: ViewInteraction = onView(withId(R.id.cityTV))
    private val cityET: ViewInteraction = onView(withId(R.id.cityET))
    private val stateText: ViewInteraction = onView(withId(R.id.cartBt))
    private val stateET: ViewInteraction = onView(withId(R.id.stateET))
    private val zipText: ViewInteraction = onView(withId(R.id.zipTV))
    private val zipET: ViewInteraction = onView(withId(R.id.zipET))
    private val countryText: ViewInteraction = onView(withId(R.id.countryTV))
    private val countryET: ViewInteraction = onView(withId(R.id.countryET))
    private val toPaymentButton: ViewInteraction = onView(withId(R.id.paymentBtn))

    // Error Text Views
    private val fullNameErrorText: ViewInteraction = onView(withId(R.id.fullNameErrorTV))
    private val address2ErrorText: ViewInteraction = onView(withId(R.id.address2ErrorTV))
    private val address1ErrorText: ViewInteraction = onView(withId(R.id.address1ErrorTV))
    private val cityErrorText: ViewInteraction = onView(withId(R.id.cityErrorTV))
    private val zipErrorText: ViewInteraction = onView(withId(R.id.zipErrorTV))
    private val stateErrorText: ViewInteraction = onView(withId(R.id.stateErrorTV))
    private val countryErrorText: ViewInteraction = onView(withId(R.id.countryErrorTV))

    fun navigateToCheckOutPage(userEmail:String,userPassword:String){
        login.login(userEmail,userPassword)
        productsCatalog.clickOnFirstProductImage()
        productsDetailsPage.addToCart()
        menu.clickOnCart()
        myCart.clickOnProceedToCheckOut()
    }

    fun fillShippingAddress(checkoutInfo: CheckoutInfo){
        handleView.performTypeText(fullNameET,checkoutInfo.firstName +" "+checkoutInfo.lastName)
        handleView.performTypeText(address1ET,checkoutInfo.address1)
        handleView.performTypeText(address2ET,checkoutInfo.address2)
        handleView.performTypeText(cityET,checkoutInfo.city)
        handleView.performTypeText(stateET,checkoutInfo.state)
        handleView.performTypeText(zipET,checkoutInfo.zip)
        handleView.performTypeText(countryET,checkoutInfo.country)
        Screenshot.takeScreenShot(ScreenshotName.FILL_SHIPPING_ADDRESS)

    }
    fun clickOnToPaymentButton(){
        handleView.performScrollClick(toPaymentButton)
        Screenshot.takeScreenShot(ScreenshotName.PAYMENT_INFO)
    }

    fun isFullNameErrorDisplayed():Boolean{
         return handleView.isViewTextDisplayed(fullNameErrorText,ErrorMessage.FULL_NAME_ERROR)
    }
    fun isAddress1ErrorDisplayed():Boolean{
        return handleView.isViewTextDisplayed(address1ErrorText,ErrorMessage.ADDRESS1_ERROR)
    }
    fun isCityErrorDisplayed():Boolean{
        return handleView.isViewTextDisplayed(cityErrorText,ErrorMessage.CITY_ERROR)
    }
    fun isZIPErrorDisplayed():Boolean{
        return handleView.isViewTextDisplayed(zipErrorText,ErrorMessage.ZIP_ERROR)
    }
    fun isCountryErrorDisplayed():Boolean{
        return handleView.isViewTextDisplayed(countryErrorText,ErrorMessage.COUNTRY_ERROR)
    }



}