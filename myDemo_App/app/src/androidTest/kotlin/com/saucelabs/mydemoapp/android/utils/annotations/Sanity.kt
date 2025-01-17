package com.saucelabs.mydemoapp.android.utils.annotations
import kotlin.annotation.AnnotationRetention.RUNTIME
import kotlin.annotation.AnnotationTarget.FUNCTION


    @Retention(RUNTIME)
    @Target(FUNCTION)
    annotation class Sanity
