package com.saucelabs.mydemoapp.android.e2eTests.testSuites


import com.saucelabs.mydemoapp.android.e2eTests.login.LoginTest
import org.junit.runner.RunWith
import org.junit.runners.Suite
class SanityTestSuite {



    @RunWith(Suite::class)
    @Suite.SuiteClasses(
        LoginTest::class

    )
    class SanityTestSuite

}