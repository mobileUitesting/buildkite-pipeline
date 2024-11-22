package com.saucelabs.mydemoapp.android.tests

import androidx.test.espresso.ViewAction
import com.saucelabs.mydemoapp.android.actions.NestingAwareScrollAction
import com.saucelabs.mydemoapp.android.base.BaseTest
import com.saucelabs.mydemoapp.android.base.ErrorFlow
import com.saucelabs.mydemoapp.android.data.DataLoader
import com.saucelabs.mydemoapp.android.data.model.UserCredentials
import com.saucelabs.mydemoapp.android.pages.CheckOutInfoPage
import com.saucelabs.mydemoapp.android.pages.LoginPage
import com.saucelabs.mydemoapp.android.pages.MenuHeaderLayout
import com.saucelabs.mydemoapp.android.pages.MyCartPage
import com.saucelabs.mydemoapp.android.pages.ProductCatalogPage
import com.saucelabs.mydemoapp.android.pages.ProductDetailsPage
import com.saucelabs.mydemoapp.android.utils.SingletonClass
import com.saucelabs.mydemoapp.android.view.activities.SplashActivity
import org.junit.Before
import org.junit.Test

class CheckOutTest: BaseTest<SplashActivity>(SplashActivity::class.java) {
    //This ViewAction For Nested ScrollView
    private val scroll: ViewAction = NestingAwareScrollAction()
    private val menu = MenuHeaderLayout()
    private val login = LoginPage()
    private val checkOutInfo=CheckOutInfoPage()


    private val handleView = com.saucelabs.mydemoapp.android.actions.ViewActions()
    private val userCredentials: UserCredentials = DataLoader().getLoginCredentials()

    @Before
    fun removeLogin() {
        SingletonClass.getInstance().isLogin = false
        SingletonClass.getInstance().hasVisualChanges = false
    }
    @Test
    @ErrorFlow
    fun mandatoryFieldsErrorVerification() {
        checkOutInfo.navigateToCheckOutPage(userCredentials.userEmail,userCredentials.userPassword)
        checkOutInfo.clickOnToPaymentButton()
        assert(checkOutInfo.isFullNameErrorDisplayed())
        assert(checkOutInfo.isAddress1ErrorDisplayed())
        assert(checkOutInfo.isCityErrorDisplayed())
        assert(checkOutInfo.isZIPErrorDisplayed())
        assert(checkOutInfo.isCountryErrorDisplayed())


    }
}