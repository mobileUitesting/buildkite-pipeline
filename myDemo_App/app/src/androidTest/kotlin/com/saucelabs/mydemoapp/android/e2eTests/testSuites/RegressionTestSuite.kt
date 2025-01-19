package com.saucelabs.mydemoapp.android.e2eTests.testSuites



import com.saucelabs.mydemoapp.android.e2eTests.TestCases.SuccessLoginWithTwoProducts
import com.saucelabs.mydemoapp.android.e2eTests.TestCases.VerifyItemRemovalFromCart
import com.saucelabs.mydemoapp.android.e2eTests.login.LoginTest
import com.saucelabs.mydemoapp.android.e2eTests.productPurchase.ProductOrderTest
import com.saucelabs.mydemoapp.android.pageObjects.Helper.LogoutTest
import org.junit.runner.RunWith
import org.junit.runners.Suite

class RegressionTestSuite {


    @RunWith(Suite::class)
    @Suite.SuiteClasses(
        LoginTest::class,
        LogoutTest::class,
        ProductOrderTest::class,
        SuccessLoginWithTwoProducts::class,
        VerifyItemRemovalFromCart::class


    )
    class RegressionSuite

}