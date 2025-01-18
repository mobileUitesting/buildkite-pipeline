package com.saucelabs.mydemoapp.android.pageObjects.Helper

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.NoMatchingViewException
import androidx.test.espresso.ViewInteraction
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.scrollTo
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withText
import org.hamcrest.Matchers.allOf
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.UiController
import androidx.test.espresso.ViewAction
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.hasDescendant
import org.hamcrest.Matcher


class ViewActionsHelper {

    fun isViewDisplayed(viewId: ViewInteraction): Boolean {
        try {
            viewId.check(matches(isDisplayed()))
            return true
        } catch (e: NoMatchingViewException) {
            return false
        }
    }

    fun performClick(viewId:ViewInteraction){
        viewId.check(matches(isDisplayed()))
            .perform(click())
    }


    fun performClick(text:String){
        onView(withText(text))
            .perform(click())
    }

    fun scrollToVisibleTextAndClick() {
        onView(allOf(withText("Add to cart"), isDisplayed()))
            .perform(scrollTo(), click())
    }

    fun clickChildViewWithId(id: Int): ViewAction {
        return object : ViewAction {
            override fun getConstraints(): Matcher<View>? {
                return null // No specific constraints
            }

            override fun getDescription(): String {
                return "Click on a child view with specified ID."
            }

            override fun perform(uiController: UiController?, view: View?) {
                val childView = view?.findViewById<View>(id)
                childView?.performClick()
            }
        }
    }

    fun clickRecyclerViewItemByText(recyclerViewId: ViewInteraction,itemText:String){

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
   }

