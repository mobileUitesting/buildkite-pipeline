package com.saucelabs.mydemoapp.android.pageObjects.Helper

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.UiController
import androidx.test.espresso.ViewAction
import androidx.test.espresso.ViewInteraction
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.closeSoftKeyboard
import androidx.test.espresso.action.ViewActions.scrollTo
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.hasDescendant
import androidx.test.espresso.matcher.ViewMatchers.isAssignableFrom
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withText
import com.saucelabs.mydemoapp.android.model.ProductModel
import com.saucelabs.mydemoapp.android.view.adapters.ProductsAdapter
import org.hamcrest.Matcher
import org.hamcrest.Matchers.allOf
import org.hamcrest.Matchers.containsString


class ViewActions {

   fun getText(view: ViewInteraction): String {
        try {
            var text = String()
            view.perform(object : ViewAction {
                override fun getConstraints(): Matcher<View> {
                    return isAssignableFrom(TextView::class.java)
                }
                override fun getDescription(): String {
                    return "Text of the view"
                }
                override fun perform(uiController: UiController, view: View) {
                    val tv = view as TextView
                    text = tv.text.toString()
                }
            })

            return text
        } catch (e: Exception) {
            return e.toString() // If an exception occurs, return false
        }
    }
    fun performClick(viewId: ViewInteraction) {
        viewId.perform(click())
    }
    fun performScrollClick(viewId: ViewInteraction) {
        viewId.perform(scrollTo(), click())
    }
    fun performClick(expectedText: String) {
        onView(withText(expectedText)).perform(click());
    }
    fun performTypeText(viewId: ViewInteraction, text: String) {
        viewId.perform(typeText(text), closeSoftKeyboard())
    }
    fun clickChildViewAtPosition(recyclerViewId: ViewInteraction, position: Int) {
        recyclerViewId.perform(
            RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(
                position
            )
        ).perform(
                RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                    position, click()
                )
            )
    }

    // RecyclerView  actions
    fun <T> getAllRecyclerViewItemsData(
        recyclerviewId: ViewInteraction, dataExtractor: String
    ): List<T> {
        val itemsData = mutableListOf<T>()
        recyclerviewId.perform((object : ViewAction {
            override fun getDescription(): String = "Get Item from RecyclerView"

            override fun getConstraints(): Matcher<View> = isDisplayed()

            override fun perform(uiController: UiController?, view: View?) {
                val recyclerView = view as RecyclerView
                val adapter = recyclerView.adapter as ProductsAdapter
                // Collect all product prices from the adapter
                for (i in 0 until adapter.itemCount) {
                    val product: ProductsAdapter = adapter
                    val model: ProductModel = product.getProductList(i)
                    val modelHeader = getValue(model, dataExtractor) as T
                    itemsData.add(modelHeader)
                }
            }
        }))

        return itemsData
    }

    fun clickRecyclerViewItemWithText(recyclerViewId: ViewInteraction, itemText: String) {
        recyclerViewId.perform(
            RecyclerViewActions.scrollTo<RecyclerView.ViewHolder>(
                hasDescendant(allOf(withText(containsString(itemText))))
            )
        ).perform(
                RecyclerViewActions.actionOnItem<RecyclerView.ViewHolder>(
                    hasDescendant(allOf(withText(containsString(itemText)))), click()
                )
            )
    }
    fun clickRecyclerViewItemWithText1(recyclerViewId: ViewInteraction, itemText: String) {
        recyclerViewId.perform(
            RecyclerViewActions.scrollTo<RecyclerView.ViewHolder>(
                hasDescendant(allOf(withText(itemText)))
            )
        ).perform(
            RecyclerViewActions.actionOnItem<RecyclerView.ViewHolder>(
                hasDescendant(allOf(withText(itemText))), click()
            )
        )
    }

    fun getTextInRecyclerView(recyclerViewId: ViewInteraction, expectedText: String):String {

        try {
            recyclerViewId.perform(
                RecyclerViewActions.scrollTo<RecyclerView.ViewHolder>(
                    hasDescendant(withText(expectedText))
                )
            )
                .check(matches(hasDescendant(withText(expectedText))))
            return expectedText
        }catch (e: Exception) {
            return e.toString() // If an exception occurs, return false
        }

    }

    fun getValue(product: ProductModel, header: String): Any? {
        return when (header) {
            "id" -> product.id
            "title" -> product.title
            "price" -> product.price
            else -> {}
        }
    }
}
