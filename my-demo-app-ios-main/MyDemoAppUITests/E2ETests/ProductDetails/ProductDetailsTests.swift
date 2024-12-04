//
//  ProductDetailsTests.swift
//  MyDemoAppUITests
//
//  Created by Sreenath Mudigonda on 02/12/24.
//

import XCTest

final class ProductDetailsTests: BaseTest{
    
    var homeScreen : HomeScreen!
    var productDetailScreen : ProductDetailScreen!
    
    override func setUp() {
        super.setUp()
        loadScreens()
    }
    
    func loadScreens(){
        homeScreen = HomeScreen(app: app)
        productDetailScreen = ProductDetailScreen(app: app)
    }
    
    func testProductDetails(){
        let productNameInHome  = homeScreen.getProductName()
        let productCostInHome = homeScreen.getProductPrice()
        
        homeScreen.tapOnProduct(index: 0)
        
        let productNameInDetails  = productDetailScreen.getProductName()
        let productCostInDetails = productDetailScreen.getProductPrice()
        
        VerificationManager.verifyBool(for: productNameInHome == productNameInDetails)
        VerificationManager.verifyBool(for: productCostInHome == productCostInDetails)
        
        productDetailScreen.tapOnBackButton()
        
    }
    
}
