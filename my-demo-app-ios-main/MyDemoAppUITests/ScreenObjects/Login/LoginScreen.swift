//
//  LoginScreen.swift
//  My Demo AppUITests
//
//  Created by Sreenath Mudigonda on 06/11/24.
//

import XCTest

class LoginScreen : BaseScreen {
    
    private lazy var userNameTextField = app.textFields.firstMatch
    private lazy var passwordTextField = app.secureTextFields.firstMatch
    private lazy var loginButton = app.buttons[ElementIdentifiers.LOGIN]
    private lazy var errorMessageLabel = app.staticTexts[ErrorMessages.INVALID_USERNAME_OR_PASSWORD]
    
    private lazy var userNameRequired = app.staticTexts[ErrorMessages.USERNAME_REQUIRED]
    private lazy var alertOk = app.alerts.buttons["OK"]
    
    /// Logs in with the provided username and password.
    ///
    /// This function enters the username and password into their respective fields and taps on the login button to initiate the login process.
    func login(userName: String, password: String) {
        enterUserName(userName)
        enterPassword(password)
        tapOnLogin()
    }
    
    /// Enters the username into the username text field.
    ///
    /// This function types the provided username into the `userNameTextField` UI element.
    func enterUserName(_ userName: String) {
        Helpers.enterText(userNameTextField, text: userName)
    }
    
    /// Enters the password into the password text field.
    ///
    /// This function types the provided password into the `passwordTextField` UI element.
    func enterPassword(_ password: String) {
        Helpers.enterText(passwordTextField, text: password)
    }
    
    /// Taps on the login button.
    ///
    /// This function performs a tap action on the `loginButton` UI element to submit the login form.
    func tapOnLogin() {
        Helpers.tapOnElement(loginButton)
    }
    
    //Failing the test case to as UI validation is not done on APP Level
    func assertErrorMessageIsDisplayed() {
        let exists = errorMessageLabel.waitForExistence(timeout: 5)
        XCTAssertTrue(exists, ErrorMessages.ERROR_MESSAGE_STATE)
        XCTAssertEqual(errorMessageLabel.label, ErrorMessages.INVALID_USERNAME_OR_PASSWORD, ErrorMessages.USERNAME_PASSWORD_DOESNOT_MATCH)
    }
    
    func assertEmptyUserName(){
        XCTAssertTrue(userNameRequired.exists)
    }
    
    func tapOnAlertOkBtn(){
        Helpers.tapOnElement(alertOk)
    }
    
}
