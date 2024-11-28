package com.saucelabs.mydemoapp.android.E2ETests

import com.saucelabs.mydemoapp.android.base.BaseTest
import com.saucelabs.mydemoapp.android.constants.Messages
import com.saucelabs.mydemoapp.android.constants.AppConstants
import com.saucelabs.mydemoapp.android.data.DataLoader
import com.saucelabs.mydemoapp.android.data.model.LoginCredentials
import com.saucelabs.mydemoapp.android.data.model.PaymentDetails
import com.saucelabs.mydemoapp.android.data.model.ShippingAddress
import com.saucelabs.mydemoapp.android.data.model.UserDetails
import com.saucelabs.mydemoapp.android.pageObjects.BasePage
import com.saucelabs.mydemoapp.android.pageObjects.CheckOutInfoPage
import com.saucelabs.mydemoapp.android.pageObjects.HomePage
import com.saucelabs.mydemoapp.android.pageObjects.LoginPage
import com.saucelabs.mydemoapp.android.pageObjects.MyCartPage
import com.saucelabs.mydemoapp.android.pageObjects.PaymentMethodPage
import com.saucelabs.mydemoapp.android.pageObjects.PlaceOrderPage
import com.saucelabs.mydemoapp.android.pageObjects.ProductDetailsPage
import com.saucelabs.mydemoapp.android.pageObjects.SideBarMenuPage
import com.saucelabs.mydemoapp.android.utils.SingletonClass
import com.saucelabs.mydemoapp.android.pageObjects.Helper.VerificationManager
import com.saucelabs.mydemoapp.android.view.activities.SplashActivity
import org.junit.Before
import org.junit.Test


class ProductOrderTest : BaseTest<SplashActivity>(SplashActivity::class.java) {
    //This ViewAction For Nested ScrollView

    private val loginPage = LoginPage()
    private val basePage = BasePage()
    private val homePage = HomePage()
    private val sideBarMenuPage = SideBarMenuPage()
    private val productsDetailsPage = ProductDetailsPage()
    private val myCartPage = MyCartPage()
    private val checkOutInfoPage = CheckOutInfoPage()
    private val paymentInfoPage = PaymentMethodPage()  //
    private val placeOrderPage = PlaceOrderPage()
    private val verificationManager = VerificationManager()

    // Getting User Information from JSon Data files
    private val loginCredentials: LoginCredentials = DataLoader().getLoginCredentials()
    private val userDetails: UserDetails = DataLoader().getUserDetails()
    private val shippingAddress: ShippingAddress = DataLoader().getShippingAddressDetails()
    private val paymentDetails: PaymentDetails = DataLoader().getPaymentDetails()

    private val index: Int = 0

    @Before
    fun clearSession() {
        SingletonClass.getInstance().isLogin = false
        SingletonClass.getInstance().hasVisualChanges = false
    }

    /*
    ** Scenario 1: This is a Scenario that checks
    * → Order Functionality of a product with the lowest price to the cart
    *  @params   userEmail, userPassword for Login
    *  @params   shippingAddressDetails, PaymentDetails
    */
    @Test
    fun verifyProductOrderFunctionality() {
        loginPage.login(loginCredentials.userEmail, loginCredentials.userPassword)
        homePage.selectLowestPriceProduct()
        productsDetailsPage.addToCart()
        basePage.clickCart()
        myCartPage.clickProceedToCheckOut()
        checkOutInfoPage.fillShippingAddressDetails(shippingAddress)
        checkOutInfoPage.clickToPaymentButton()
        paymentInfoPage.fillPaymentDetails(paymentDetails)
        paymentInfoPage.clickReviewOrderButton()
        placeOrderPage.clickPlaceOrderButton()
        verificationManager.verifyTextAndStopTest(
            placeOrderPage.getCheckoutSuccessMessage(),
            AppConstants.CHECKOUT_COMPLETE,
            Messages.VERIFY_CHECK_OUT_COMPLETE
        )
        placeOrderPage.clickContinueShoppingButton()
        sideBarMenuPage.logOut()
    }
}
