package com.saucelabs.mydemoapp.android.pages

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.ViewInteraction
import androidx.test.espresso.action.ViewActions.scrollTo
import androidx.test.espresso.matcher.ViewMatchers.withId
import com.saucelabs.mydemoapp.android.R
import com.saucelabs.mydemoapp.android.actions.NestingAwareScrollAction
import com.saucelabs.mydemoapp.android.actions.RecyclerViewActions
import com.saucelabs.mydemoapp.android.actions.SideNavClickAction
import com.saucelabs.mydemoapp.android.actions.ViewActions
import com.saucelabs.mydemoapp.android.actions.Wait
import com.saucelabs.mydemoapp.android.constants.ErrorMessage
import com.saucelabs.mydemoapp.android.constants.PageConstants
import com.saucelabs.mydemoapp.android.constants.ScreenshotName
import org.junit.Assert
import org.junit.Assert.assertEquals

class ProductCatalogPage {

    private val handleView = ViewActions()
    private val handleRecyclerView = RecyclerViewActions()
    private val productsDetailsPage = ProductDetailsPage()
    private val sort = SortDialogPage()

    private val productTV: ViewInteraction = onView(withId(R.id.productTV))
    private val productRV: ViewInteraction = onView(withId(R.id.productRV))
    private val productImage: ViewInteraction = onView(withId(R.id.productIV))
    private val productTitle: ViewInteraction = onView(withId(R.id.titleTV))
    private val productImageId: Int = R.id.productIV

    private val socialLL: ViewInteraction = onView(withId(R.id.socialLL))
    private val twitterIV: ViewInteraction = onView(withId(R.id.twitterIV))
    private val faceBookIV: ViewInteraction = onView(withId(R.id.FacebookIV))
    private val linkedInIV: ViewInteraction = onView(withId(R.id.LinkedInIV))

    private fun productRecycler(): ViewInteraction {
        return productRV
    }

    fun productTitle(): ViewInteraction {
        return productTitle
    }

    fun scrollToPosition(position: Int) {
        handleView.recyclerScrollToPosition(productRV, position)
    }

    fun clickOnPosition(position: Int) {
        handleView.recyclerActionOnItemAtPosition(productRV, position, NestingAwareScrollAction())
    }

    fun clickOnTwitterLink(){
        handleView.performClick(twitterIV)
    }

    fun clickOnFacebookLink(){
        handleView.performClick(faceBookIV)
    }
    fun clickOnLinkedInLink(){

        handleView.performClick(linkedInIV)
    }

    fun clickOnFirstProductImage() {
        clickOnProductAtPosition(0)
        productsDetailsPage.waitForProductName()
        Screenshot.takeScreenShot(ScreenshotName.PRODUCT_DETAILS)
    }

    private fun clickOnProductAtPosition(position: Int) {
        handleView.clickOnChildViewAtPosition(productRV, position)
    }

    fun selectMaxPriceProduct(){
        val productPrice:List<Double> = handleRecyclerView.getAllRecyclerViewItemsData(productRecycler(),"price")
        val maxPrice=productPrice.maxOrNull()
        handleView.recyclerScrollToPosition(productRV,productPrice.indexOf(maxPrice))
        handleView.clickOnChildViewAtPosition(productRV,productPrice.indexOf(maxPrice))
       // clickOnProductAtPosition(productPrice.indexOf(maxPrice))
    }

    fun verifySocialSiteLinksDisplayed() {
        Assert.assertTrue(ErrorMessage.TWITTER_LINK_NOT_DISPLAYED, handleView.isViewDisplayed(twitterIV))
        Assert.assertTrue(ErrorMessage.FACEBOOK_LINK_NOT_DISPLAYED, handleView.isViewDisplayed(faceBookIV))
        Assert.assertTrue(ErrorMessage.LINKED_IN_LINK_NOT_DISPLAYED, handleView.isViewDisplayed(linkedInIV))
        Assert.assertTrue(ErrorMessage.COPY_RIGHTS_NOT_DISPLAYED,handleView.isViewTextDisplayed(PageConstants.COPY_RIGHTS))
        Screenshot.takeScreenShot(ScreenshotName.SOCIAL_SITES)
    }

    fun verifyTwitterNavigation(url:String){
       clickOnTwitterLink()
        Thread.sleep(2000)
        Assert.assertTrue("Twitter Link Not Working As Expected",handleView.verifyWebViewUrl(url))
     }
    fun verifyFacebookNavigation(url:String){
        clickOnFacebookLink()
        Thread.sleep(2000)
        Assert.assertTrue("FaceBook Link Not Working As Expected",handleView.verifyWebViewUrl(url))
    }
    fun verifyLinkedInNavigation(url:String){
        clickOnLinkedInLink()
        Thread.sleep(2000)
        Assert.assertTrue("Linked-In Link Not Working As Expected",handleView.verifyWebViewUrl(url))
    }
    fun filterByNameAscending(){
        sort.performSortingByText(PageConstants.SORT_BY_NAME_ASC)
        Screenshot.takeScreenShot(ScreenshotName.SORT_BY_NAME_ASC)
        val productNames:List<String> = handleRecyclerView.getAllRecyclerViewItemsData(productRecycler(),"title")
        val sortedProductNames = productNames.sorted()
        // Assert that the original list matches the sorted list
        assertEquals("Product names are not in ascending order", sortedProductNames, productNames)

    }
    fun filterByNameDescending(){
        val productNames:List<String> = handleRecyclerView.getAllRecyclerViewItemsData(productRecycler(),"title")
        sort.performSortingByText(PageConstants.SORT_BY_NAME_DES)
        val productNamesDesc:List<String> = handleRecyclerView.getAllRecyclerViewItemsData(productRecycler(),"title")
        Screenshot.takeScreenShot(ScreenshotName.SORT_BY_NAME_DESC)
        val sortedProductNames = productNames.sortedDescending()
        // Assert that the original list matches the sorted list
        assertEquals("Product names are not in descending order", sortedProductNames, productNamesDesc)

    }
    fun filterByPriceAscending(){
        sort.performSortingByText(PageConstants.SORT_BY_PRICE_ASC)
        val productPrice:List<Double> = handleRecyclerView.getAllRecyclerViewItemsData(productRecycler(),"price")
        val sortedProductPrice = productPrice.sorted()
        // Assert that the original list matches the sorted list
        assertEquals("Product Price are not in ascending order", sortedProductPrice, productPrice)

    }
    fun filterByPriceDescending(){
        val productPrice:List<Double> = handleRecyclerView.getAllRecyclerViewItemsData(productRecycler(),"price")
        sort.performSortingByText(PageConstants.SORT_BY_PRICE_DES)
        val productPriceDesc:List<Double> = handleRecyclerView.getAllRecyclerViewItemsData(productRecycler(),"price")
        val sortedProductPrice = productPrice.sortedDescending()
        // Assert that the original list matches the sorted list
        assertEquals("Product Price are not in descending order", sortedProductPrice, productPriceDesc)

    }
    fun scrollToBottom() {
        // Replace R.id.scrollView with your ScrollView's ID
        socialLL.perform(scrollTo())
    }

}