//
//  LoginFailureWithInvalidCredentialTests.swift
//  MyDemoAppUITests
//
//  Created by Mohammad Gouse Jani on 28/11/24.
//

import XCTest

final class LoginFailureWithInvalidCredentialTests: BaseTest {

    var homeScreen : HomeScreen!
    var moreScreen : MoreScreen!
    var loginScreen : LoginScreen!
    var userCredentialsTestData: UserCredentialsTestDataModel!
    
    override func setUp() {
        super.setUp()
        loadScreens()
        loadTestData()
    }
    
    func loadScreens(){
        homeScreen = HomeScreen(app: app)
        moreScreen = MoreScreen(app: app)
        loginScreen = LoginScreen(app: app)
    }
    
    func loadTestData(){
        userCredentialsTestData = Helpers.loadTestData(from: AppConstants.LOGIN,ofType: UserCredentialsTestDataModel.self)
    }
    
    func testLoginFailedWithInvalidCredential(){
        homeScreen.tapOnMoreTab()
        moreScreen.tapOnLogin()
        loginScreen.login(userName: userCredentialsTestData.invalidCredentials.userName ?? "", password: userCredentialsTestData.invalidCredentials.password ?? "")
        loginScreen.assertErrorMessageIsDisplayed()
    }
    
}
