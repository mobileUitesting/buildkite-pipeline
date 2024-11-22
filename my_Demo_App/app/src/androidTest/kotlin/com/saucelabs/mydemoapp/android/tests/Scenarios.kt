package com.saucelabs.mydemoapp.android.tests

import androidx.test.espresso.Espresso.pressBack
import androidx.test.espresso.ViewAction
import androidx.test.espresso.intent.Intents
import com.saucelabs.mydemoapp.android.actions.NestingAwareScrollAction
import com.saucelabs.mydemoapp.android.base.BaseTest
import com.saucelabs.mydemoapp.android.base.HappyFlow
import com.saucelabs.mydemoapp.android.constants.PageConstants
import com.saucelabs.mydemoapp.android.constants.ScreenshotName
import com.saucelabs.mydemoapp.android.data.DataLoader
import com.saucelabs.mydemoapp.android.data.model.CheckoutInfo
import com.saucelabs.mydemoapp.android.data.model.ProductModel
import com.saucelabs.mydemoapp.android.data.model.UserCredentials
import com.saucelabs.mydemoapp.android.pages.CheckOutInfoPage
import com.saucelabs.mydemoapp.android.pages.LoginPage
import com.saucelabs.mydemoapp.android.pages.MenuHeaderLayout
import com.saucelabs.mydemoapp.android.pages.MyCartPage
import com.saucelabs.mydemoapp.android.pages.PaymentMethodsPage
import com.saucelabs.mydemoapp.android.pages.PlaceOrderPage
import com.saucelabs.mydemoapp.android.pages.ProductCatalogPage
import com.saucelabs.mydemoapp.android.pages.ProductDetailsPage
import com.saucelabs.mydemoapp.android.pages.SortDialogPage
import com.saucelabs.mydemoapp.android.utils.SingletonClass
import com.saucelabs.mydemoapp.android.view.activities.SplashActivity
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test


class Scenarios : BaseTest<SplashActivity>(SplashActivity::class.java) {
    //This ViewAction For Nested ScrollView

    private val menu = MenuHeaderLayout()
    private val login = LoginPage()
    private val sort = SortDialogPage()
    private val productsCatalog = ProductCatalogPage()
    private val productsDetailsPage=ProductDetailsPage()
    private val myCart=MyCartPage()
    private val checkInfo=CheckOutInfoPage()
    private val paymentInfo=PaymentMethodsPage()
    private val placeOrder=PlaceOrderPage()

    private val handleView = com.saucelabs.mydemoapp.android.actions.ViewActions()
    private val handleRecyclerView = com.saucelabs.mydemoapp.android.actions.RecyclerViewActions()
    private val userCredentials: UserCredentials = DataLoader().getLoginCredentials()
    private val urls: List<String> = DataLoader().getUrls()
    private val checkOutInfo: CheckoutInfo = DataLoader().getCheckInfoDetails()


    @Before
    fun removeLogin() {
        SingletonClass.getInstance().isLogin = false
        SingletonClass.getInstance().hasVisualChanges = false
    }

    /*
    ** Scenario 1: This is a Scenario that checks
    * → Login
    * → Add a product with the lowest price to the cart
    * → Verify product order functionality is working properly
    * → Logout
    *  @params   userEmail, userPassword for Login
    *  @params   checkOutInfo   for user Shipping Address anf Payment Info
    */
    @Test
    @HappyFlow
    fun productOrderFunctionalityVerifying() {
        menu.navigateToLoginPage()
        login.login(userCredentials.userEmail,userCredentials.userPassword)
        sort.performSortingByText(PageConstants.SORT_BY_PRICE_ASC)
        productsCatalog.clickOnFirstProductImage()
        productsDetailsPage.addToCart()
        menu.clickOnCart()
        myCart.clickOnProceedToCheckOut()
        checkInfo.fillShippingAddress(checkOutInfo)
        checkInfo.clickOnToPaymentButton()
        paymentInfo.fillPaymentDetails(checkOutInfo)
        placeOrder.clickOnReviewOrderButton()
        placeOrder.clickOnPlaceOrderButton()
        placeOrder.clickOnContinueShoppingButton()
        menu.waitForMenu()
        menu.clickOnMenu()
        menu.waitForMenuDisplay()
        menu.clickOnMenuItem(10)
        menu.clickOnLogOut(PageConstants.LOG_OUT)
    }



    /*
 ** Scenario 2: This is a Scenario that checks
 * → Login
 * → Add a product to the cart
 * ->Remove the product
 * → Verify Proceed To Checkout button is disabled
 *  And Go Shopping button Enabled
 * → Logout
 *  @params userEmail, userPassword for Login
 */
    @Test
    @HappyFlow
    fun emptyMyCartPageDisplayingIfAllProductsRemoved() {
     login.login(userCredentials.userEmail,userCredentials.userPassword)
      productsCatalog.clickOnFirstProductImage()
      productsDetailsPage.addToCart()
      menu.clickOnCart()
      myCart.clickOnRemoveItemButton()
        myCart.waitForNoItemTitle()
      myCart.emptyMyCartUIVerification()
    }

    /*
** Scenario 3: This is a Scenario that checks
* → Login
* → click on My cart
* -> Verify Proceed To Checkout button is disabled
*  And Go Shopping button Enabled
* → Logout
*/
    @Test
    @HappyFlow
    fun emptyMyCartPageUIVerification() {
        login.login(userCredentials.userEmail,userCredentials.userPassword)
        menu.clickOnCart()
        myCart.emptyMyCartUIVerification()
    }



  /*  ** Scenario 4: This is a Scenario that checks user able to redirect to Login Page
        *if  Add Products to Cart and Proceed to CheckOut with out Initial Login
    * → Add Product To Cart
    * → click on My cart
    * → Click on Proceed To CheckOut Button
    * → User redirect to Login Page Enter User Credentials
    * → Verify product order functionality is working properly
    * → Logout
    *  @params userEmail, userPassword for Login
    *  @params   checkOutInfo   for user Shipping Address anf Payment Info
    */
    @Test
    @HappyFlow
    fun productOrderFunctionalityWithOutInitialLogin() {
        productsCatalog.clickOnFirstProductImage()
        productsDetailsPage.addToCart()
        menu.clickOnCart()
        myCart.clickOnProceedToCheckOut()
        login.userLogin(userCredentials.userEmail,userCredentials.userPassword)
        checkInfo.fillShippingAddress(checkOutInfo)
        checkInfo.clickOnToPaymentButton()
        paymentInfo.fillPaymentDetails(checkOutInfo)
        placeOrder.clickOnReviewOrderButton()
        placeOrder.clickOnPlaceOrderButton()
        placeOrder.clickOnContinueShoppingButton()
        menu.waitForMenu()
        menu.clickOnMenu()
        menu.waitForMenuDisplay()
        menu.clickOnMenuItem(10)
        menu.clickOnLogOut(PageConstants.LOG_OUT)
    }


    /* ** Scenario 5: Verify all the filters are working correctly
      * Login
      * → Verify all the filters are working correctly
      * → Logout
        @params userEmail, userPassword for Login
    */
   @Test
    @HappyFlow
    fun filtersWorkingVerification() {
      menu.navigateToLoginPage()
        login.login(userCredentials.userEmail,userCredentials.userPassword)
        productsCatalog.filterByNameAscending()
        productsCatalog.filterByNameDescending()
        productsCatalog.filterByPriceAscending()
        productsCatalog.filterByPriceDescending()
    }

    /* ** Scenario 5: Verify all the Social Sites working correctly
     * verify all the Social sites are visible
     * → Verify all the Social sites redirecting to their respective pages
    */
    @Test
    @HappyFlow
    fun socialSitesWorkingVerification() {
        menu.waitForMenu()
        productsCatalog.scrollToBottom()
        productsCatalog.verifySocialSiteLinksDisplayed()
        productsCatalog.verifyTwitterNavigation(urls[0])
        handleView.devicePressBack()
        productsCatalog.verifyFacebookNavigation(urls[1])
        handleView.devicePressBack()
        productsCatalog.clickOnLinkedInLink()
        productsCatalog.verifyLinkedInNavigation(urls[2])
        handleView.devicePressBack()
        menu.waitForMenu()
    }

    /*
   ** Scenario 6: This is a Scenario that checks
   * → Login
   * → Add a product with the highest price to the cart
   * → Verify product order functionality is working properly
   * → Logout
   *  @params   userEmail, userPassword for Login
   *  @params   checkOutInfo   for user Shipping Address anf Payment Info
   */
    @Test
    @HappyFlow
    fun highestPriceProductOrderFunctionalityVerifying() {
        menu.navigateToLoginPage()
        login.login(userCredentials.userEmail,userCredentials.userPassword)
        sort.performSortingByText(PageConstants.SORT_BY_PRICE_DES)
        productsCatalog.clickOnFirstProductImage()
        productsDetailsPage.addToCart()
        menu.clickOnCart()
        myCart.clickOnProceedToCheckOut()
        checkInfo.fillShippingAddress(checkOutInfo)
        checkInfo.clickOnToPaymentButton()
        paymentInfo.fillPaymentDetails(checkOutInfo)
        placeOrder.clickOnReviewOrderButton()
        placeOrder.clickOnPlaceOrderButton()
        placeOrder.clickOnContinueShoppingButton()
        menu.waitForMenu()
        menu.clickOnMenu()
        menu.waitForMenuDisplay()
        menu.clickOnMenuItem(10)
        menu.clickOnLogOut(PageConstants.LOG_OUT)
    }
}
