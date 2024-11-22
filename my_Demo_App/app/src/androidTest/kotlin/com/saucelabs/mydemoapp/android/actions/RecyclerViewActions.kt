package com.saucelabs.mydemoapp.android.actions

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.UiController
import androidx.test.espresso.ViewAction
import androidx.test.espresso.ViewInteraction
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import com.saucelabs.mydemoapp.android.R
import com.saucelabs.mydemoapp.android.model.ProductModel
import com.saucelabs.mydemoapp.android.view.adapters.ProductsAdapter
import org.hamcrest.Matcher

import kotlin.reflect.KProperty1

class RecyclerViewActions {

    fun getMinPricePosition(prices:List<Double>):Int{
        val minPrice = prices.minOrNull()
       return  prices.indexOf(minPrice)
    }
    fun getMaxPricePosition(prices:List<Double>):Int{
        val maxPrice = prices.maxOrNull()
        return  prices.indexOf(maxPrice)
    }

    fun getMinPrice(prices:List<Double>):Double?{
        return  prices.minOrNull()
    }

    fun getMaxPrice(prices:List<Double>):Double?{
        return  prices.maxOrNull()
    }


    fun <T> getAllRecyclerViewItemsData(recyclerviewId: ViewInteraction,dataExtractor:String): List<T> {
        val itemsData = mutableListOf<T>()
        recyclerviewId.perform(( object : ViewAction {
            override fun getDescription(): String = "Get Item from RecyclerView"

            override fun getConstraints(): Matcher<View> = isDisplayed()

            override fun perform(uiController: UiController?, view: View?) {

                val recyclerView = view as RecyclerView
                val adapter = recyclerView.adapter as ProductsAdapter
                // Collect all product prices from the adapter
                for (i in 0 until adapter.itemCount) {
                    val product: ProductsAdapter =adapter
                    val  model:ProductModel =   product.getProductList(i)
                    val modelHeader=getValue(model,dataExtractor) as T
                    itemsData.add(modelHeader)

                }
            }
        }))

        return itemsData
    }

    fun getValue(product: ProductModel,header: String ): Any? {
        return when (header) {
            "id" -> product.id
            "title" -> product.title
            "price" -> product.price
            else -> {}
        }
    }

}