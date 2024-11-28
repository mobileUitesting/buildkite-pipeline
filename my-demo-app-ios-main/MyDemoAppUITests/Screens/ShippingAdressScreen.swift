//
//  CheckOutScreen.swift
//  My Demo AppUITests
//
//  Created by Sreenath Mudigonda on 07/11/24.
//

import XCTest

class ShippingAdressScreen : BaseScreen{
    
    private lazy var fullNameTextField = app.textFields.element(boundBy: 0)
    private lazy var addressOneTextField = app.textFields.element(boundBy: 1)
    private lazy var addressTwoTextField = app.textFields.element(boundBy: 2)
    private lazy var cityTextField = app.textFields.element(boundBy: 3)
    private lazy var stateTextField = app.textFields.element(boundBy: 5)
    private lazy var zipCodeTextField = app.textFields.element(boundBy: 4)
    private lazy var countryTextField = app.textFields.element(boundBy: 6)
    private lazy var toPaymentButton = app.buttons[ElementIdentifiers.TO_PAYMENT_BUTTON]
    private lazy var okButton = app.buttons[ElementIdentifiers.OK_BUTTON]
    private lazy var fullNameErrorMessage = app.staticTexts[ErrorMessages.VALIDATION_MESSAGE_FOR_FULL_NAME]
    private lazy var addressOneErrorMessage = app.staticTexts[ErrorMessages.VALIDATION_MESSAGE_FOR_ADDRESS_ONE]
    private lazy var addressTwoErrorMessage = app.staticTexts[ErrorMessages.VALIDATION_MESSAGE_FOR_ADDRESS_TWO]
    private lazy var cityErrorMessage = app.staticTexts[ErrorMessages.VALIDATION_MESSAGE_FOR_CITY]
    private lazy var zipCodeErrorMessage = app.staticTexts[ErrorMessages.VALIDATION_MESSAGE_FOR_ZIP_CODE]
    private lazy var countryErrorMessage = app.staticTexts[ErrorMessages.VALIDATION_MESSAGE_FOR_COUNTRY]
    
    /// Enters the full name into the full name text field.
    ///
    /// This function types the provided full name into the `fullNameTextField` UI element.
    func enterFullName(_ fullName: String) {
        Helpers.enterText(fullNameTextField, text: fullName)
    }
    
    /// Enters the address (line 1) into the address text field.
    ///
    /// This function types the provided address into the `addressOneTextField` UI element.
    func enterAddressOne(_ address: String) {
        Helpers.enterText(addressOneTextField, text: address)
    }
    
    /// Enters the city into the city text field.
    ///
    /// This function types the provided city into the `cityTextField` UI element.
    func enterCity(_ city: String) {
        Helpers.enterText(cityTextField, text: city)
    }
    
    /// Enters the state into the state text field.
    ///
    /// This function types the provided state into the `stateTextField` UI element.
    func enterState(_ state: String) {
        Helpers.enterText(stateTextField, text: state)
    }
    
    /// Enters the zip code into the zip code text field.
    ///
    /// This function types the provided zip code into the `zipCodeTextField` UI element.
    func enterZipCode(_ zipCode: String) {
        Helpers.enterText(zipCodeTextField, text: zipCode)
    }
    
    /// Enters the country into the country text field.
    ///
    /// This function types the provided country into the `countryTextField` UI element.
    func enterCountry(_ country: String) {
        Helpers.enterText(countryTextField, text: country)
    }
    
    /// Taps on the payment button.
    ///
    /// This function triggers a tap action on the `toPaymentButton` UI element to proceed with payment.
    func tapOnPaymentButton() {
        Helpers.tapOnElement(toPaymentButton)
    }
    
    /// Taps on the OK button.
    ///
    /// This function triggers a tap action on the `okButton` UI element to dismiss any pop-ups or alerts.
    func tapOnOkButton() {
        Helpers.tapOnElement(okButton)
    }
    
    /// Checks for an error message in the full name text field.
    ///
    /// This function taps the payment button and compares the error message in the `fullNameErrorMessage` label
    /// to the provided `actualMessage`.
    func checkForFullNameTextFieldError(actualMessage: String) -> Bool {
        tapOnPaymentButton()
        return fullNameErrorMessage.label == actualMessage
    }
    
    /// Checks for an error message in the address line 1 text field.
    ///
    /// This function taps the payment button and compares the error message in the `addressOneErrorMessage` label
    /// to the provided `actualMessage`.
    func checkForAddressOneTextFieldError(actualMessage: String) -> Bool {
        tapOnPaymentButton()
        return addressOneErrorMessage.label == actualMessage
    }
    
    /// Checks for an error message in the address line 2 text field.
    ///
    /// This function taps the payment button and compares the error message in the `addressTwoTextField` label
    /// to the provided `actualMessage`.
    func checkForAddressTwoTextFieldError(actualMessage: String) -> Bool {
        tapOnPaymentButton()
        return addressTwoTextField.label == actualMessage
    }
    
    /// Checks for an error message in the city text field.
    ///
    /// This function taps the payment button and compares the error message in the `cityErrorMessage` label
    /// to the provided `actualMessage`.
    func checkForCityTextFieldError(actualMessage: String) -> Bool {
        tapOnPaymentButton()
        return cityErrorMessage.label == actualMessage
    }
    
    /// Checks for an error message in the zip code text field.
    ///
    /// This function taps the payment button and compares the error message in the `zipCodeErrorMessage` label
    /// to the provided `actualMessage`.
    func checkForZipCodeTextFieldError(actualMessage: String) -> Bool {
        tapOnPaymentButton()
        return zipCodeErrorMessage.label == actualMessage
    }
    
    /// Checks for an error message in the country text field.
    ///
    /// This function taps the payment button and compares the error message in the `countryErrorMessage` label
    /// to the provided `actualMessage`.
    func checkForCountryTextFieldError(actualMessage: String) -> Bool {
        tapOnPaymentButton()
        return countryErrorMessage.label == actualMessage
    }
    
    
    func enterUserAddressToPayment(_ userAdress:UserAddressModel){
        enterFullName(userAdress.fullName ?? "")
        enterAddressOne(userAdress.addressOne ?? "")
        enterCity(userAdress.city ?? "")
        enterState(userAdress.state ?? "")
        enterZipCode(userAdress.zipCode ?? "")
        enterCountry(userAdress.country ?? "")
        tapOnPaymentButton()
    }
    
}
