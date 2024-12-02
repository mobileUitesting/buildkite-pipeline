package com.saucelabs.mydemoapp.android.utils

import android.content.Context
import android.util.Log
import java.io.File
import java.io.FileWriter
import java.io.IOException

object Logger {
    private const val TAG = "EspressoTest"
    private var logFile: File? = null

    fun initialize(context: Context) {
        logFile = File(context.filesDir, "test_logs.txt")
    }
    private fun writeToFile(message: String) {
        try {
            logFile?.let {
                val writer = FileWriter(it, true)
                writer.appendLine(message)
                writer.close()
            }
        } catch (e: IOException) {
            Log.e(TAG, "Failed to write log to file", e)
        }
    }
    fun logInfo(message: String) {
        Log.i(TAG, message)
        writeToFile("INFO: $message")
    }
    fun logError(message: String, throwable: Throwable? = null) {
        Log.e(TAG, message, throwable)
        writeToFile("ERROR: $message")
    }
    fun logDebug(message: String) {
        Log.d(TAG, message)
        writeToFile("DEBUG: $message")
    }
    fun logWarning(message: String) {
        Log.w(TAG, message)
        writeToFile("WARNING: $message")
    }
}
