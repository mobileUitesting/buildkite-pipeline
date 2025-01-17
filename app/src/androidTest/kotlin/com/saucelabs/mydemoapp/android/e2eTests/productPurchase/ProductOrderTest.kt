package com.saucelabs.mydemoapp.android.e2eTests.productPurchase



import com.saucelabs.mydemoapp.android.base.BaseTest
import com.saucelabs.mydemoapp.android.data.model.UserCredentials
import com.saucelabs.mydemoapp.android.pageObjects.Helper.CheckOutDetailsPage
import com.saucelabs.mydemoapp.android.pageObjects.Helper.LoginPage
import com.saucelabs.mydemoapp.android.pageObjects.Helper.PaymentDetailsPage
import com.saucelabs.mydemoapp.android.pageObjects.Helper.PlaceOrderPage
import com.saucelabs.mydemoapp.android.pageObjects.Helper.ProductCartPage
import com.saucelabs.mydemoapp.android.pageObjects.Helper.ProductDetailsPage
import com.saucelabs.mydemoapp.android.pageObjects.Helper.ProductHomePage
import com.saucelabs.mydemoapp.android.data.DataBinder
import com.saucelabs.mydemoapp.android.data.model.CardPaymentDetails
import com.saucelabs.mydemoapp.android.data.model.ShippingDetails
import com.saucelabs.mydemoapp.android.utils.annotations.Regression
import com.saucelabs.mydemoapp.android.view.activities.SplashActivity
import io.qameta.allure.kotlin.junit4.Tag
import org.junit.Test

class ProductOrderTest : BaseTest<SplashActivity>(SplashActivity::class.java) {

    private val userCredentials: UserCredentials = DataBinder().getUserCredentials()
    private val shippingDetails: ShippingDetails = DataBinder().getShippingDetails()
    private val cardPaymentDetails: CardPaymentDetails = DataBinder().getCardPaymentDetails()

    private val loginPage = LoginPage()
    private val proudctHomePage = ProductHomePage()
    private val productdetailsPage = ProductDetailsPage()
    private val productCartPage = ProductCartPage()
    private val checkOutDetailsPage = CheckOutDetailsPage()
    private val paymentDetailsPage = PaymentDetailsPage()
    private val placeOrderPage = PlaceOrderPage()

    @Regression
    @Tag("regression")
    @Test
    fun purchaseProductOrder()
    {
        loginPage.login(userCredentials)
        proudctHomePage.clickOnProductPosition()
        productdetailsPage.productColorClick(position = 0)
        productdetailsPage.productCartSelect()
        productdetailsPage.cartClick()
        productCartPage.productOnCheckOut()
        checkOutDetailsPage.userShippingDetails(shippingDetails)
        checkOutDetailsPage.paymentButtonClick()
        paymentDetailsPage.paymentDetailsSubmit(cardPaymentDetails)
        paymentDetailsPage.paymentOrderClick()
        placeOrderPage.placeOrder()
        placeOrderPage.completCheckOut()
    }

}
