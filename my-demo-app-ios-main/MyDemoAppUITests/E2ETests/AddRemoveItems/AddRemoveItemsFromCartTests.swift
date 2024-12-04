//
//  AddRemoveItemsFromCartTests.swift
//  MyDemoAppUITests
//
//  Created by Mohammad Gouse Jani on 02/12/24.
//

import XCTest

final class AddRemoveItemsFromCartTests: BaseTest {

    var homeScreen : HomeScreen!
    var moreScreen : MoreScreen!
    var loginScreen : LoginScreen!
    var cartScreen : CartScreen!
    var userCredentialsTestData: UserCredentialsTestDataModel!
    
    let firstItemIndex = 0
    let secondItemIndex = 1
    let thirdItemIndex = 2
    
    override func setUp() {
        super.setUp()
        loadScreens()
        loadTestData()
    }
    
    /// This method loads required screeens for the tests
    func loadScreens() {
        homeScreen = HomeScreen(app: app)
        moreScreen = MoreScreen(app: app)
        loginScreen = LoginScreen(app: app)
        cartScreen = CartScreen(app: app)
    }
    
    /// This functions loads test data for the tests
    func loadTestData() {
        userCredentialsTestData = Helpers.loadTestData(from: AppConstants.LOGIN,ofType: UserCredentialsTestDataModel.self)
    }
    
    /// This method load the credentials for environment
    func loadCredentialsForEnvironment() {
        // Get the environment (staging/production) from the environment variables
        let environment = ProcessInfo.processInfo.environment[AppConstants.DEMO_ENVIRONMENT] ?? AppConstants.STAGING
        
        print("Using environment: \(environment)")
        
        if environment == AppConstants.STAGING {
         
        } else if environment == AppConstants.PRODUCTION {
           // let productionCredentials = Helpers.loadProductionCredentials()
           // print("Production credentials: \(productionCredentials?.userName ?? "")")
        }
    }
    
    /// This method defines Add and Remove items from cart
    func testAddRemoveItemsFromCart() {
        /// Login
        homeScreen.tapOnMoreTab()
        moreScreen.tapOnLogin()
        loginScreen.login(userName: userCredentialsTestData.validCredentials.userName ?? "", password: userCredentialsTestData.validCredentials.password ?? "")
        homeScreen.tapOnMoreTab()
        VerificationManager.verifyBool(for: moreScreen.checkForLogOut())
        homeScreen.tapOnCatalogTab()
        /// Add product to cart
        let (procutName,productCost) = homeScreen.getItemDetails(at: firstItemIndex)
        homeScreen.addToCart(index: firstItemIndex)
        let productCostInCart = cartScreen.getProductPriceInString()
        let productNameInCart = cartScreen.getProductNameString()
        VerificationManager.verifyBool(for: procutName == productNameInCart)
        VerificationManager.verifyBool(for: productCost == productCostInCart)
        homeScreen.tapOnCatalogTab()
        homeScreen.addToCart(index: secondItemIndex)
        homeScreen.tapOnCatalogTab()
        homeScreen.addToCart(index: thirdItemIndex)
        cartScreen.tapOnRemoveFromCartButton()
    }
}
