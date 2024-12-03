//
//  LoginWithEmptyFieldsTests.swift
//  MyDemoAppUITests
//
//  Created by Sreenath Mudigonda on 29/11/24.
//

import XCTest

final class LoginWithEmptyFieldsTests: BaseTest {
    
    var homeScreen : HomeScreen!
    var moreScreen : MoreScreen!
    var loginScreen : LoginScreen!
    
    override func setUp() {
        super.setUp()
        loadScreens()
    }
    /// in this function loading the screens
    func loadScreens(){
        homeScreen = HomeScreen(app: app)
        moreScreen = MoreScreen(app: app)
        loginScreen = LoginScreen(app: app)
    }
    
    func testEmptyLogin(){
        TestLogger.shared.log("Test started: \(self.name)")
        homeScreen.tapOnMoreTab()
        moreScreen.tapOnLogin()
        loginScreen.tapOnLogin()
        loginScreen.assertEmptyUserName()
        loginScreen.tapOnAlertOkBtn()
        TestLogger.shared.log("Test finished: \(self.name)")
        
    }
    
    
}
