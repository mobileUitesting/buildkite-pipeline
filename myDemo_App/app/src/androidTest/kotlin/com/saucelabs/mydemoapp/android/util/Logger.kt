package com.saucelabs.mydemoapp.android.util

import android.util.Log
import timber.log.Timber

object Logger {

    /**
     * Initialize Timber for logging.
     * @param isDebug true for Debug builds, false for Release builds.
     */
    fun init(isDebug: Boolean) {
        if (isDebug) {
            Timber.plant(Timber.DebugTree())
        } else {
            Timber.plant(ReleaseTree())
        }
    }

    // Logging wrapper functions
    fun d(message: String, vararg args: Any?) = Timber.d(message, *args)
    fun e(message: String, vararg args: Any?) = Timber.e(message, *args)
    fun i(message: String, vararg args: Any?) = Timber.i(message, *args)
    fun w(message: String, vararg args: Any?) = Timber.w(message, *args)
    fun wtf(message: String, vararg args: Any?) = Timber.wtf(message, *args)
    fun e(t: Throwable, message: String, vararg args: Any?) = Timber.e(t, message, *args)

    /**
     * Custom Release Tree to log only WARN, ERROR, and WTF in production.
     */
    private class ReleaseTree : Timber.Tree() {
        override fun log(priority: Int, tag: String?, message: String, t: Throwable?) {
            if (priority == Log.VERBOSE || priority == Log.DEBUG) {
                return // Skip logging for VERBOSE and DEBUG levels
            }
            Log.println(priority, tag ?: "ReleaseLogger", message)
            t?.let { Log.e(tag ?: "ReleaseLogger", message, it) }
        }
    }
}
