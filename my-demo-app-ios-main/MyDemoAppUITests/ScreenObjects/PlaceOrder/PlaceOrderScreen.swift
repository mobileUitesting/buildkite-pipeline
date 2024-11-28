//
//  PlaceOrderScreen.swift
//  My Demo AppUITests
//
//  Created by Sreenath Mudigonda on 07/11/24.
//

import XCTest

class PlaceOrderScreen : BaseScreen {
    var userAddressTestData:UserAddressModel!
    
    override init(app: XCUIApplication) {
        super.init(app: app)
        userAddressTestData = Helpers.loadTestData(from: AppConstants.ADDRESS,ofType: UserAddressModel.self)
    }
    private lazy var name = app.staticTexts[userAddressTestData.fullName ?? ""]
    private lazy var address = app.staticTexts[userAddressTestData.addressOne ?? ""]
    private lazy var city = app.staticTexts[userAddressTestData.city ?? ""]
    private lazy var country = app.staticTexts[userAddressTestData.country ?? ""]
    private lazy var placeOrderButton = app.staticTexts[ElementIdentifiers.PLACE_ORDER_BUTTON]
   
    
    /// Taps on the "Place Order" button.
    ///
    /// This function triggers a tap action on the `placeOrderButton` UI element.
    func tapOnPlaceOrder() {
        Helpers.tapOnElement(placeOrderButton)
    }
    
   
    
    /// Checks if a static text element contains the given text.
    ///
    /// This function checks if the app's static text contains the specified string, returning `true` if it does.
    func checkForStaticText(_ text: String) -> Bool {
        let predicate = NSPredicate(format: "label CONTAINS[c] %@", text)
        let elementQuery = app.staticTexts.containing(predicate)
        return elementQuery.count > 0
    }
}
