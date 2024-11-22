package com.saucelabs.mydemoapp.android.verification

class VerificationManager {
    //verify String
    //verify Boolean

    fun verifyStringAndStopTest(
        actualValue: String?,
        expectedValue: String?,
        message: String?
    ): Boolean {
        return true
    }
}