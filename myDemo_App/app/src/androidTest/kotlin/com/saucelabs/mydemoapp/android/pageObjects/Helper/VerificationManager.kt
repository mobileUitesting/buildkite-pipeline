package com.saucelabs.mydemoapp.android.pageObjects.Helper

import com.saucelabs.mydemoapp.android.utils.Logger
import org.junit.Assert

class VerificationManager {

        // Helper function to handle assertions and logging
        private fun <T> performVerification(
            actualValue: T,
            expectedValue: T,
            message: String,
            stopTestOnFailure: Boolean = false
        ): Boolean {
            val tag = "EspressoTestLogger"
            return try {
                Assert.assertEquals(message, expectedValue, actualValue)
                Logger.logInfo("$tag PASS: $message: ACTUAL: $actualValue EXPECTED: $expectedValue")
                true
            } catch (assertionError: AssertionError) {
                Logger.logInfo("$tag FAIL: $message: ${assertionError.message}")
                if (stopTestOnFailure) {
                    Assert.fail("$message: FAIL")
                }
                false
            }
        }

        // Verifies text values without stopping the test on failure
        fun verifyText(actualValue: String?, expectedValue: String?, message: String?): Boolean {
            requireNotNull(message) { "Message cannot be null." }
            return performVerification(actualValue, expectedValue, message)
        }

        // Verifies text values and stops the test on failure
        fun verifyTextAndStopTest(actualValue: String, expectedValue: String, message: String): Boolean {
            return performVerification(actualValue, expectedValue, message, stopTestOnFailure = true)
        }

        // Verifies boolean values
        fun verifyPresent(actualValue: Boolean, expectedValue: Boolean, message: String): Boolean {
            return performVerification(actualValue, expectedValue, message)
        }
    }

