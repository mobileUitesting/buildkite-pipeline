//
//  ErrorMessages.swift
//  My Demo AppUITests
//
//  Created by Sreenath Mudigonda on 13/11/24.
//

import Foundation


struct ErrorMessages{
    
    static let VALIDATION_MESSAGE_FOR_FULL_NAME = "Please provide your full name."
    static let VALIDATION_MESSAGE_FOR_ADDRESS_ONE = "Please provide your address."
    static let VALIDATION_MESSAGE_FOR_ADDRESS_TWO = "Please provide your city."
    static let VALIDATION_MESSAGE_FOR_CITY = "Please provide your city."
    static let VALIDATION_MESSAGE_FOR_ZIP_CODE = "Please provide your zip."
    static let VALIDATION_MESSAGE_FOR_COUNTRY = "Please provide your country."
    static let VALIDATION_MESSAGE_FOR_CHECKOUT = "Value looks invalid."
    static let INCREASE_BUTTON_FAILED_TO_WORK =  "Increase button is not working fine"
    static let DECREASE_BUTTON_FAILED_TO_WORK = "Decrease button is not working fine"
    static let DOES_NOT_EXISTS = "does not exists"
    static let ELEMENT_IS_NOT_TRACEABLE = "Element not interactable or does not exist"
    static let TEST_DATA_NOT_FOUND = "TestData.json not found in the test bundle."
    static let FAILED_TO_LOAD = "Failed to load data from TestData.json:"
    static let INVALID_USERNAME_OR_PASSWORD = "Invalid username or password."
    static let USERNAME_REQUIRED = "Username is required"
    static let ERROR_MESSAGE_STATE = "Error message should appear after tapping Login button"
    static let USERNAME_PASSWORD_DOESNOT_MATCH = "Username and password do not match any user in this service"
}
