package com.saucelabs.mydemoapp.android.base

// Use the command below to run test classes or test methods marked by this annotation only
//
//   ./gradlew connectedAndroidTest -Pandroid.testInstrumentationRunnerArguments.annotation=com.saucelabs.mydemoapp.android.TestOnlyThis
@Target(
    AnnotationTarget.FUNCTION,
    AnnotationTarget.PROPERTY_GETTER,
    AnnotationTarget.PROPERTY_SETTER,
    AnnotationTarget.CLASS
)
@Retention(AnnotationRetention.RUNTIME)
annotation class TestOnlyThis
