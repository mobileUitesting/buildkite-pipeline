package com.saucelabs.mydemoapp.android.actions

import android.app.Instrumentation
import android.content.Intent
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.UiController
import androidx.test.espresso.ViewAction
import androidx.test.espresso.ViewInteraction
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.closeSoftKeyboard
import androidx.test.espresso.action.ViewActions.scrollTo
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.intent.Intents.intended
import androidx.test.espresso.intent.Intents.intending
import androidx.test.espresso.intent.matcher.IntentMatchers.hasAction
import androidx.test.espresso.intent.matcher.IntentMatchers.hasData
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.hasDescendant
import androidx.test.espresso.matcher.ViewMatchers.isAssignableFrom
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.isEnabled
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.uiautomator.UiDevice
import org.hamcrest.CoreMatchers.not
import org.hamcrest.Matcher
import org.hamcrest.Matchers.allOf


class ViewActions {

    fun isViewDisplayed(viewId: ViewInteraction): Boolean {
        return try {
            viewId.check(matches(isDisplayed()))
            true // If the view is displayed, return true
        } catch (e: Exception) {
            false // If an exception occurs, return false
        }
    }

    fun isViewDisplayed(viewMatcher: Matcher<View> ): Boolean {
        return try {
            matches(viewMatcher)
            true // If the view is displayed, return true
        } catch (e: Exception) {
            false // If an exception occurs, return false
        }
    }

    fun getText(matcher: ViewInteraction): String {
        var text = String()
        matcher.perform(object : ViewAction {
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
    }

   fun getView(viewId: ViewInteraction): View {
        val viewHolder = arrayOfNulls<View>(1)
        var  viewHolderIndex=0
            viewId.perform(object : ViewAction {
            override fun getConstraints(): Matcher<View> {
                return ViewMatchers.isAssignableFrom(View::class.java)
            }
            override fun getDescription(): String {
                return "Getting view with ID $viewId"
            }
            override fun perform(uiController: UiController, view: View) {
                viewHolder[viewHolderIndex] = view
            }
        })

        return viewHolder[viewHolderIndex]!!
    }
     fun  getPreviousSiblingView(expectedText: String){
         // First, find the TextView containing the target text, e.g. "Item 2"
         onView(withText(expectedText))
             .perform(object : ViewAction {
                 override fun getDescription(): String {
                     return "Find the button before the TextView with specific text"
                 }

                 override fun getConstraints(): Matcher<View> {
                     return isDisplayed() // Ensure that the TextView is visible
                 }

                 override fun perform(uiController: UiController?, view: View?) {
                     // Assuming the button is in the same parent as the TextView
                     val parent = (view?.parent as ViewGroup)
                     val button = parent.getChildAt(0) // Assuming the button is the first child

                     // Perform the click on the previous element, i.e. the button
                     button.performClick()
                 }
             })

     }

    //return true If the view is displayed with expected Text,
    // return false If an exception occurs
    fun  isViewTextDisplayed(viewId: ViewInteraction,expectedText: String):Boolean{
        return try {
            viewId.check(matches(allOf(withText(expectedText), isDisplayed())))
            true // If the view is displayed with expected Text, return true
        } catch (e: Exception) {
            false // If an exception occurs, return false
        }
    }

    /* Returns  True if a view matches based on its text property value.
     * Params:
     * text – String with the text to match
    */
    fun  isViewTextDisplayed(expectedText: String):Boolean{
        return try {
            onView(withText(expectedText))
                .check(matches(isDisplayed()))
            true // If the view is displayed with expected Text, return true
        } catch (e: Exception) {
            false // If an exception occurs, return false
        }
    }

    fun  isMenuViewTextDisplayed(viewMatcher: Matcher<View>,expectedText: String):Boolean{
        return try {
            onView(allOf(viewMatcher, // The BottomNavigationItemView ID
                        hasDescendant(withText(expectedText))  // Check if the child TextView has the text "Home"
            ))
                .check(matches(isDisplayed()))
            true // If the view is displayed with expected Text, return true
        } catch (e: Exception) {
            false // If an exception occurs, return false
        }
    }

    fun checkMatch(viewId: ViewInteraction,expectedMessage: String){
        viewId.check(matches(withText(expectedMessage)))
    }
    fun performClick(viewId: ViewInteraction){
        viewId.perform(click())
    }

    fun performScrollClick(viewId: ViewInteraction){
        viewId.perform(scrollTo(), click())
    }

    fun performClick(viewMatcher: Matcher<View>){
        viewMatcher.matches(performClick(viewMatcher))

    }
    fun performClick(expectedText:String){
        onView(withText(expectedText))
            .perform(click());

    }
    fun isViewDisabled(viewId: ViewInteraction):Boolean{

        return try {
        viewId.check(matches(not(isEnabled())))
            true // If the view is disabled , return true
        } catch (e: Exception) {
            false // If an exception occurs, return false
        }
    }
    fun isViewEnabled(viewId: ViewInteraction):Boolean{
        return try {
            viewId.check(matches(isEnabled()))
            true // If the view is Enabled , return true
        } catch (e: Exception) {
            false // If an exception occurs, return false
        }
    }

    fun scrollTOPosition(viewId: ViewInteraction,position:Int){
        viewId.perform(ViewActions.scrollTo(position))

    }
    fun scrollCompletelyTo(viewId: ViewInteraction,position:Int){
        viewId.perform(ViewActions.scrollCompletelyTo())
    }


    fun performTypeText(viewId: ViewInteraction,text: String){
        viewId.perform(typeText(text), closeSoftKeyboard())

    }

    fun isSnackBarDisplayed(snackBarMsg:String):Boolean{
        return try {
            onView(withText(snackBarMsg))
                .inRoot(isSnackBar())
                .check(matches(isDisplayed()))
            true
        } catch (e: Exception) {
            false
        }

    }

    // Recycler View Actions
    fun recyclerScrollToPosition(viewId: ViewInteraction,position:Int){
        viewId.perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(position))

    }
    fun recyclerActionOnItemAtPosition(viewId: ViewInteraction,position:Int,action:ViewAction){
        viewId.perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(position))
            .perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                position,
                action
            ))
    }
    fun clickOnChildViewAtPosition1(recyclerViewId: ViewInteraction,position:Int,childViewId: Int) {
        // Perform click on the first ImageView inside the RecyclerView
        recyclerViewId  // Find the RecyclerView by its ID
            .perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(position,
                clickChildViewWithId(childViewId))) // Click the first ImageView
    }
    fun clickOnChildViewAtPosition(recyclerViewId: ViewInteraction,position:Int) {
        recyclerViewId.perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(position))
            .perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(position, click()));
    }
    fun clickChildViewWithId(childViewId: Int): ViewAction {
        return object : ViewAction {
            override fun getConstraints(): Matcher<View> {
                return isAssignableFrom(ViewGroup::class.java)
            }

            override fun getDescription(): String {
                return "Click on a child view with specified ID"
            }

            override fun perform(uiController: UiController?, view: View?) {
                val recyclerView = view as RecyclerView
                val viewHolder = recyclerView.findViewHolderForAdapterPosition(0)
                //val childView = viewHolder?.itemView?.findViewById<View>(childViewId)
                val childView = viewHolder?.itemView?.findViewById<View>(childViewId)
                childView?.performClick()  // Perform click on the child view
            }
        }
    }

    fun verifyWebViewUrl(url:String):Boolean {
        // Verify that the WebView is displayed
        return try {
           /* intended(hasAction(Intent.ACTION_VIEW))  // Check if the Intent uses ACTION_VIEW
            intended(hasData(url))*/

            intending(
                allOf(
                    hasAction(Intent.ACTION_VIEW),
                    hasData(url)
                ))
                .respondWith(Instrumentation.ActivityResult(0, null))
            true
        } catch (e: Exception) {
            false
        }


       // Replace with your expected Twitter URL

    }
    fun devicePressBack() {
         val device =
        UiDevice.getInstance(androidx.test.platform.app.InstrumentationRegistry.getInstrumentation())
        device.pressBack()
    }

}