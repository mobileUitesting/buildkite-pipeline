package com.saucelabs.mydemoapp.android.e2eTests.testSuites



import com.saucelabs.mydemoapp.android.e2eTests.login.LoginWithValidCredentialsTest
import com.saucelabs.mydemoapp.android.e2eTests.productPurchase.ProductOrderTest
import com.saucelabs.mydemoapp.android.pageObjects.Helper.LogoutActivityTest
import org.junit.runner.RunWith
import org.junit.runners.Suite

class RegressionTestSuite {


    @RunWith(Suite::class)
    @Suite.SuiteClasses(
        LoginWithValidCredentialsTest::class,
        LogoutActivityTest::class,
        ProductOrderTest::class

    )
    class RegressionSuite

}