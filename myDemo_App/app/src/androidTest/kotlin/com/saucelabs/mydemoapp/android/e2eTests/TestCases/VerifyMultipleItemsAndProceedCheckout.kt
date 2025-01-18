package com.saucelabs.mydemoapp.android.e2eTests.TestCases


import com.saucelabs.mydemoapp.android.base.BaseTest
import com.saucelabs.mydemoapp.android.data.DataBinder
import com.saucelabs.mydemoapp.android.data.model.CardPaymentDetails
import com.saucelabs.mydemoapp.android.data.model.ShippingDetails
import com.saucelabs.mydemoapp.android.data.model.UserCredentials
import com.saucelabs.mydemoapp.android.pageObjects.CheckOutDetailsPage
import com.saucelabs.mydemoapp.android.pageObjects.Helper.SideMenuPage
import com.saucelabs.mydemoapp.android.pageObjects.LoginPage
import com.saucelabs.mydemoapp.android.pageObjects.PaymentDetailsPage
import com.saucelabs.mydemoapp.android.pageObjects.PlaceOrderPage
import com.saucelabs.mydemoapp.android.pageObjects.ProductDetailsPage
import com.saucelabs.mydemoapp.android.pageObjects.ProductHomePage
import com.saucelabs.mydemoapp.android.view.activities.SplashActivity
import org.junit.Test

class VerifyMultipleItemsAndProceedCheckout : BaseTest<SplashActivity>(SplashActivity::class.java) {

    private val userCredentials: UserCredentials = DataBinder().getUserCredentials()
    private val shippingDetails: ShippingDetails = DataBinder().getShippingDetails()
    private val cardPaymentDetails: CardPaymentDetails = DataBinder().getCardPaymentDetails()

    private val loginPage = LoginPage()
    private val proudctHomePage = ProductHomePage()
    private val sideMenuPage = SideMenuPage()
    private val productdetailsPage = ProductDetailsPage()
    private val checkOutDetailsPage = CheckOutDetailsPage()
    private val paymentDetailsPage = PaymentDetailsPage()
    private val placeOrderPage = PlaceOrderPage()


    @Test
    fun productAddedAndCheckout() {
        loginPage.login(userCredentials)
        proudctHomePage.clickOnProductPosition()
        productdetailsPage.productColorClick(position = 0)
        productdetailsPage.productCartSelect()
        sideMenuPage.selectCatalogue()
        proudctHomePage.clickOnProductPosition()
        productdetailsPage.clickOnProductPositionOne(position = 1)
        productdetailsPage.productCartSelect()
        checkOutDetailsPage.userShippingDetails(shippingDetails)
        checkOutDetailsPage.paymentButtonClick()
        paymentDetailsPage.paymentDetailsSubmit(cardPaymentDetails)
        paymentDetailsPage.paymentOrderClick()
        placeOrderPage.placeOrder()
        placeOrderPage.completCheckOut()
    }
}