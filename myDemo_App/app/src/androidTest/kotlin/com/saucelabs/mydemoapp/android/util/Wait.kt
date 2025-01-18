package com.saucelabs.mydemoapp.android.util

import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.ViewInteraction
import androidx.test.espresso.assertion.ViewAssertions
import java.util.concurrent.CountDownLatch
import java.util.concurrent.TimeUnit
import java.util.concurrent.atomic.AtomicBoolean

class Wait() {
    companion object {
        private val TAG = "EspressoCustomWait"

        private fun waitForCondition(condition: () -> Boolean, timeout: Long): Boolean {
            val latch = CountDownLatch(1)
            val conditionMet = AtomicBoolean(false)

            Thread {
                val startTime = System.currentTimeMillis()
                while (System.currentTimeMillis() - startTime < timeout) {
                    if (condition()) {
                        conditionMet.set(true)
                        latch.countDown()
                        return@Thread
                    }
                    Thread.sleep(50) // Poll every 50ms
                }
                latch.countDown()
            }.start()

            latch.await(timeout, TimeUnit.MILLISECONDS)
            return conditionMet.get()
        }

        fun waitFOrView(viewId: ViewInteraction){
            val timeout:Long=2000
            waitForView(viewId,timeout)
        }


        fun waitForView(viewId: ViewInteraction, timeout: Long) {
            val start = System.currentTimeMillis()
            while (System.currentTimeMillis() - start <= timeout) {
                try {
                    viewId.check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
                    break
                } catch (t: Throwable) {
                }

                try {
                    Thread.sleep(500)
                } catch (e: InterruptedException) {
                    throw RuntimeException(e)
                }
            }
        }
    }
}
