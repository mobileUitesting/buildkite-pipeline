//
//  SuccessfulLoginAndItemPurchaseTests.swift
//  My Demo AppUITests
//
//  Created by Sreenath Mudigonda on 26/11/24.
//

import XCTest

class LoginAndItemPurchaseTests: BaseTest {
    
    var homeScreen : HomeScreen!
    var moreScreen : MoreScreen!
    var loginScreen : LoginScreen!
    var cartScreen : CartScreen!
    var shippingAddressScreeen: ShippingAdressScreen!
    var checkOutScreen:CheckOutScreen!
    var placeOrderScreen:PlaceOrderScreen!
    var checkoutCompleteScreen : CheckoutCompleteScreen!
    
    var userCredentialsTestData: UserCredentialsTestDataModel!
    var userAddressTestData : UserAddressModel!
    var userCardDetailsTestData : UserCardDetailsModel!
    
    let firstItemIndex = 0
    let secondItemIndex = 1
    
    override func setUp() {
        super.setUp()
        loadScreens()
        loadTestData()
    }
    
    /// This method loads all the required screens for the tests
    func loadScreens(){
    
        homeScreen = HomeScreen(app: app)
        moreScreen = MoreScreen(app: app)
        loginScreen = LoginScreen(app: app)
        shippingAddressScreeen =  ShippingAdressScreen(app: app)
        cartScreen = CartScreen(app: app)
        checkOutScreen = CheckOutScreen(app: app)
        placeOrderScreen = PlaceOrderScreen(app: app)
        checkoutCompleteScreen = CheckoutCompleteScreen(app: app)
   
    }
    
    /// This functions loads dependent test data for the tests
    func loadTestData(){
       
        userCredentialsTestData = JSONParser.loadTestData(from: AppConstants.LOGIN,ofType: UserCredentialsTestDataModel.self)
        userAddressTestData = JSONParser.loadTestData(from: AppConstants.ADDRESS,ofType: UserAddressModel.self)
        userCardDetailsTestData = JSONParser.loadTestData(from: AppConstants.CARD_DETAILS,ofType: UserCardDetailsModel.self)
   
    }
    
    ///This function simulates the purchase order fucntionality
    ///
    ///Verifys login, product which is added to cart is correct or not and checkout success page
    ///
    
    func testLoginAndItemPurchase(){
        /// Login
        homeScreen.tapOnMoreTab()
        moreScreen.tapOnLogin()
        loginScreen.login(userName: userCredentialsTestData.validCredentials.userName ?? "", password: userCredentialsTestData.validCredentials.password ?? "")
        
        homeScreen.tapOnMoreTab()
        /// Verifying whether user logged in succefully or not
        VerificationManager.verifyBool(for: moreScreen.checkForLogOut())
        
        homeScreen.tapOnCatalogTab()
        
        // add product to cart
        let (procutName,productCost) = homeScreen.getItemDetails(at: firstItemIndex)
        homeScreen.addToCart(index: firstItemIndex)
        let productCostInCart = cartScreen.getProductPriceInString()
        let productNameInCart = cartScreen.getProductNameString()
        
        VerificationManager.verifyBool(for: procutName == productNameInCart)
        VerificationManager.verifyBool(for: productCost == productCostInCart)
        
        //add one more product
        homeScreen.tapOnCatalogTab()
        homeScreen.addToCart(index: secondItemIndex)
        
        cartScreen.tapOnProceedToCheckOutButton()
        
        shippingAddressScreeen.enterUserAddressToPayment(userAddressTestData)
        checkOutScreen.enterCardDetails(userCardDetailsTestData)
        placeOrderScreen.tapOnPlaceOrder()
        /// verifying for checkout successful message
        VerificationManager.verifyBool(for: checkoutCompleteScreen.checkForContinueShoppingButton())
        checkoutCompleteScreen.tapOnCotinueShoppingButton()
    }
}
