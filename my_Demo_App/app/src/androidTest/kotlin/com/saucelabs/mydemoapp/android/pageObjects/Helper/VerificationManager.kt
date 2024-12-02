package com.saucelabs.mydemoapp.android.pageObjects.Helper

import com.saucelabs.mydemoapp.android.utils.Logger
import org.junit.Assert

class VerificationManager {

    fun verifyText(actualValue: String?, expectedValue: String?,message: String?): Boolean {
        return true
    }
    fun verifyTextAndStopTest(actualValue: String,expectedValue: String,message: String): Boolean {
        var isVerified = false
        val tag = "EspressoTestLogger :  "
        val stackTrace = Thread.currentThread().stackTrace
        val element = stackTrace[3]
        val failMessage= "$message: FAIL"
        try {
            Assert.assertEquals(message , expectedValue, actualValue)
            Logger.logInfo(
                "PASS : $message: ACTUAL : $actualValue    EXPECTED :$expectedValue"
            )
            isVerified = true
        } catch (assertionError: AssertionError) {
            //ErrorUtil.addVerificationFailure(assertionError);
            Logger.logInfo("FAIL     : " + failMessage + ": " + assertionError.message)
            Assert.fail(failMessage)
        }
        return isVerified
    }
 fun verifyPresent(actualValue: Boolean,expectedValue: Boolean,message: String):Boolean{
     var isPresent = false
     val tag = "EspressoTestLogger :  "
     try {
         Assert.assertEquals(message , expectedValue, actualValue)
         Logger.logInfo(
             "PASS : $message: ACTUAL : $actualValue    EXPECTED :$expectedValue"
         )
         isPresent = true
     } catch (assertionError: AssertionError) {
         //ErrorUtil.addVerificationFailure(assertionError);
         Logger.logInfo("FAIL     : " + message + ": " + assertionError.message)
         Assert.fail(message)
     }
     return isPresent
 }

}