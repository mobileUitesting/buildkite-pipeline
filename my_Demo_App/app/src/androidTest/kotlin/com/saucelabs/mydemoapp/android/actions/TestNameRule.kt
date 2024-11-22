package com.saucelabs.mydemoapp.android.actions

import org.junit.rules.TestRule
import org.junit.runner.Description
import org.junit.runners.model.Statement

class TestNameRule : TestRule {
    private var testClassName: String? = null
    private var testMethodName: String? = null

    override fun apply(base: Statement, description: Description): Statement {
        testClassName = description.testClass.simpleName
        testMethodName = description.methodName
        return base
    }

    fun getTestClassName(): String? {
        return testClassName
    }

    fun getTestMethodName(): String? {
        return testMethodName
    }
}