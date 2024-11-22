package com.saucelabs.mydemoapp.android.base

import android.app.Activity
import androidx.test.espresso.intent.Intents
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.google.firebase.firestore.FirebaseFirestore
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
open class BaseTest<T : Activity>(activityClass: Class<T>){

    private lateinit var firestore: FirebaseFirestore
    @get:Rule
    var rule = ActivityScenarioRule(activityClass)


    @Before
    open fun setUp() {
      //  IdlingRegistry.getInstance().register(mIdlingResource)
        firestore = FirebaseFirestore.getInstance()
        Intents.init()
    }

    @After
    fun tearDown() {
        Intents.release()
    }
    //val rule = ActivityScenarioRule(LoginActivity::class.java)
 }



