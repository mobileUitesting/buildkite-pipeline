package com.saucelabs.mydemoapp.android.e2eTests.TestCases


import com.saucelabs.mydemoapp.android.base.BaseTest
import com.saucelabs.mydemoapp.android.data.DataBinder
import com.saucelabs.mydemoapp.android.data.model.UserCredentials
import com.saucelabs.mydemoapp.android.pageObjects.LoginPage
import com.saucelabs.mydemoapp.android.pageObjects.ProductCartPage
import com.saucelabs.mydemoapp.android.pageObjects.ProductDetailsPage
import com.saucelabs.mydemoapp.android.pageObjects.ProductHomePage
import com.saucelabs.mydemoapp.android.view.activities.SplashActivity
import org.junit.Test

class VerifyItemRemovalFromCartInCheckout : BaseTest<SplashActivity>(SplashActivity::class.java) {

    private val userCredentials: UserCredentials = DataBinder().getUserCredentials()

    private val loginPage = LoginPage()
    private val proudctHomePage = ProductHomePage()
    private val productdetailsPage = ProductDetailsPage()
    private val productCartPage = ProductCartPage()



    @Test
    fun purchaseProductOrder() {
        loginPage.login(userCredentials)
        proudctHomePage.clickOnProductPosition()
        productdetailsPage.productColorClick(position = 0)
        productdetailsPage.productCartSelect()
        productdetailsPage.cartClick()
        productCartPage.productRemoveFromList()
        productCartPage.EmptyCartClick()

    }
}