//
//  CheckOutScreen.swift
//  My Demo AppUITests
//
//  Created by Sreenath Mudigonda on 07/11/24.
//

import XCTest

class CheckOutScreen: BaseScreen{
    
    private lazy var fullNameTextField = app.textFields.element(boundBy: 0)
    private lazy var cardNumberTextField = app.textFields.element(boundBy: 1)
    private lazy var expiryDateTextField = app.textFields.element(boundBy: 2)
    private lazy var securityCodeTextField = app.textFields.element(boundBy: 3)
    private lazy var reviewOrder = app.buttons[ElementIdentifiers.REVIEW_ORDER_BUTTON]
    private lazy var errorMessage = app.staticTexts[ErrorMessages.VALIDATION_MESSAGE_FOR_CHECKOUT]
    private lazy var okButton = app.buttons[ElementIdentifiers.OK_BUTTON]
    
    /// Taps on the "Review Order" button.
    ///
    /// This function triggers a tap action on the "Review Order" UI element using the `Helpers.tapOnElement` method.
    func tapOnReviewOrder() {
        Helpers.tapOnElement(reviewOrder)
    }
    
    /// Checks for validation by tapping on the "Review Order" button and verifying the error message.
    ///
    /// This function taps the "Review Order" button and returns `true` if the error message is displayed.
    func checkForValidation() -> Bool {
        tapOnReviewOrder()
        return errorMessage.exists
    }
    
    /// Taps on the "OK" button.
    ///
    /// This function performs a tap action on the "OK" button UI element using the `Helpers.tapOnElement` method.
    func tapOnOkButton() {
        Helpers.tapOnElement(okButton)
    }
    
    /// Enters a name into the full name text field.
    ///
    /// This function enters the provided name into the `fullNameTextField` UI element.
    func enterName(_ name: String) {
        Helpers.enterText(fullNameTextField, text: name)
    }
    
    /// Enters a card number into the card number text field.
    ///
    /// This function enters the provided card number into the `cardNumberTextField` UI element.
    func enterCardNumber(_ cardNumber: String) {
        Helpers.enterText(cardNumberTextField, text: cardNumber)
    }
    
    /// Enters an expiry date into the expiry date text field.
    ///
    /// This function enters the provided expiry date into the `expiryDateTextField` UI element.
    func enterExpiryDate(_ expiryDate: String) {
        Helpers.enterText(expiryDateTextField, text: expiryDate)
    }
    
    /// Enters a security code into the security code text field.
    ///
    /// This function enters the provided security code into the `securityCodeTextField` UI element.
    func enterSecurityCode(_ securityCode: String) {
        Helpers.enterText(securityCodeTextField, text: securityCode)
    }
    
    func enterCardDetails(_ cardDetails:UserCardDetailsModel){
        enterName(cardDetails.nameOnCard ?? "")
        enterCardNumber(cardDetails.cardNumber ?? "")
        enterExpiryDate(cardDetails.expiryDate ?? "")
        enterSecurityCode(cardDetails.securityCode ?? "")
        tapOnReviewOrder()
    }
    
}
