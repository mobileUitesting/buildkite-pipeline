package com.saucelabs.mydemoapp.android.pages

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.ViewInteraction
import androidx.test.espresso.matcher.ViewMatchers.withId
import com.saucelabs.mydemoapp.android.R
import com.saucelabs.mydemoapp.android.actions.ViewActions
import com.saucelabs.mydemoapp.android.constants.ScreenshotName
import com.saucelabs.mydemoapp.android.data.model.CheckoutInfo

class PaymentMethodsPage {


    private val handleView = ViewActions()

    //Payment Methods
    private val enterPaymentMethodText: ViewInteraction = onView(withId(R.id.enterPaymentMethodTV))
    private val paymentDetailsText: ViewInteraction = onView(withId(R.id.paymentDetailsTV))
    private val cardText: ViewInteraction = onView(withId(R.id.cardTV))
    private val visaImage: ViewInteraction = onView(withId(R.id.visaIV))
    private val mastercardImage: ViewInteraction = onView(withId(R.id.mastercardIV))
    private val nameText: ViewInteraction = onView(withId(R.id.nameTV))
    private val nameET: ViewInteraction = onView(withId(R.id.nameET))
    private val cardNumberText: ViewInteraction = onView(withId(R.id.cardNumberTV))
    private val cardNumberET: ViewInteraction = onView(withId(R.id.cardNumberET))
    private val expirationDateText: ViewInteraction = onView(withId(R.id.expirationDateTV))
    private val expirationDateET: ViewInteraction = onView(withId(R.id.expirationDateET))
    private val securityCodeText: ViewInteraction = onView(withId(R.id.securityCodeTV))
    private val securityCodeET: ViewInteraction = onView(withId(R.id.securityCodeET))
    private val questionIV: ViewInteraction = onView(withId(R.id.questionIV))
    private val billingAddressCheck: ViewInteraction = onView(withId(R.id.billingAddressCB))
    private val reviewOrderButton: ViewInteraction = onView(withId(R.id.paymentBtn))

    // Error Text Views
    private val fullNameErrorText: ViewInteraction = onView(withId(R.id.nameErrorTV))
    private val cardNumberErrorText: ViewInteraction = onView(withId(R.id.cardNumberErrorTV))
    private val expirationDateErrorText: ViewInteraction = onView(withId(R.id.expirationDateErrorTV))
    private val securityCodeErrorText: ViewInteraction = onView(withId(R.id.securityCodeErrorTV))




     fun fillPaymentDetails(checkoutInfo: CheckoutInfo){
         handleView.performTypeText(nameET,checkoutInfo.firstName +" "+checkoutInfo.lastName)
         handleView.performTypeText(cardNumberET,checkoutInfo.cardNumber)
         handleView.performTypeText(expirationDateET,checkoutInfo.expirationDate)
         handleView.performTypeText(securityCodeET, checkoutInfo.securityCode)
        // handleView.performTypeText(billingAddressCheck,checkoutInfo.isSameShipping)

         Screenshot.takeScreenShot(ScreenshotName.FILL_PAYMENT_INFO)

     }

    fun clickOnReviewOrderButton(){
        handleView.performClick(reviewOrderButton)
    }


}