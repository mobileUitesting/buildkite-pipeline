package com.saucelabs.mydemoapp.android.e2eTests.testSuites


import com.saucelabs.mydemoapp.android.e2eTests.login.LoginWithValidCredentialsTest
import org.junit.runner.RunWith
import org.junit.runners.Suite
class SanityTestSuite {



    @RunWith(Suite::class)
    @Suite.SuiteClasses(
        LoginWithValidCredentialsTest::class

    )
    class SanityTestSuite

}