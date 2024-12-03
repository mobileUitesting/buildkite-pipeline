//
//  MyCartScreen.swift
//  My Demo AppUITests
//
//  Created by Sreenath Mudigonda on 07/11/24.
//

import XCTest

class CartScreen : BaseScreen{
    
    private lazy var increaseButton = app.buttons[ElementIdentifiers.INCREASE]
    private lazy var decreaseButton = app.buttons[ElementIdentifiers.DECREASE]
    private lazy var proceedToCheckOutButton = app.buttons[ElementIdentifiers.PROCEED_TO_CHECKOUT]
    private lazy var removeFromCartButton = app.buttons[ElementIdentifiers.REMOVE_FROM_CART]
    private lazy var productCountLbl = app.staticTexts[ElementIdentifiers.PRODUCT_COUNT]
    private lazy var productPriceLbl = app.staticTexts[ElementIdentifiers.PRODUCT_PRICE]
    private lazy var productNameLbl = app.staticTexts[ElementIdentifiers.PRODUCT_NAME_IN_CART]
    private lazy var productImage = app.images[ElementIdentifiers.PRODUCT_IMAGE_IN_CART]
    private lazy var totalPriceLbl = app.staticTexts[ElementIdentifiers.TOTAL_PRICE]
    private lazy var noItemLbl = app.staticTexts[ElementIdentifiers.NO_ITEMS]
    
    /// Taps on the "Increase Product Count" button.
    ///
    /// This function triggers a tap action on the `increaseBtn` UI element.
    func tapOnIncreaseProductCountButton() {
        Helpers.tapOnElement(increaseButton)
    }
    
    /// Taps on the "Decrease Product Count" button.
    ///
    /// This function triggers a tap action on the `decreaseBtn` UI element.
    func tapOnDecreaseProductCountButton() {
        Helpers.tapOnElement(decreaseButton)
    }
    
    
    /// Taps on the "Proceed to Checkout" button.
    ///
    /// This function triggers a tap action on the `proceedToCheckOutBtn` UI element.
    func tapOnProceedToCheckOutButton() {
        Helpers.tapOnElement(proceedToCheckOutButton)
        TestLogger.shared.log("\(AppConstants.CART_SCREEN): \(LogMessages.TAPPED_PROCEED_TO_CHECKOUT)")
    }
    
    /// Taps on the "Remove from Cart" button.
    ///
    /// This function triggers a tap action on the `removeFromCartBtn` UI element.
    func tapOnRemoveFromCartButton() {
        Helpers.tapOnFirstMatch(in: app, matching: .button, label: ElementIdentifiers.REMOVE_FROM_CART)
    }
    
    /// Gets the current product count.
    ///
    /// This function returns the product count as an integer from the `productCountLbl` label.
    func getProductCount() -> Int {
        return Int(productCountLbl.label) ?? 0
    }
    
    /// Gets the current product price.
    ///
    /// This function returns the product price as a double from the `productPriceLbl` label.
    func getProductPriceInString() -> String {
        return productPriceLbl.label
    }
    
    func getProductPrice() -> Double {
        return Double(productPriceLbl.label) ?? 0.0
    }
    /// Gets the total price.
    ///
    /// This function returns the total price as a double from the `totalPriceLbl` label.
    func getTotalPrice() -> Double {
        return Double(totalPriceLbl.label) ?? 0.0
    }
    
    /// Checks if the "No Items" text is visible.
    ///
    /// This function returns `true` if the `noItemLbl` UI element is visible on the screen.
    func checkForNoItemsText() -> Bool {
        return Helpers.isUIElementVisible(noItemLbl)
    }
    
    /// Checks if the "Proceed to Checkout" button is disabled.
    ///
    /// This function returns `true` if the `proceedToCheckOutBtn` is not enabled.
    func isCheckOutButtonDisabled() -> Bool {
        return proceedToCheckOutButton.isEnabled
    }
    
    /// Gets the product price as a string.
    ///
    /// This function returns the product price as a string from the `productPriceLbl` label.
    func getProductPriceString() -> String {
        return productPriceLbl.label
    }
    
    /// Gets the product name as a string.
    ///
    /// This function returns the product name as a string from the `productNameLbl` label.
    func getProductNameString() -> String {
        return productNameLbl.label
    }
    
    /// Checks if the product image is displaying.
    ///
    /// This function returns `true` if the `productImage` UI element exists on the screen.
    func checkImageIsDisplaying() -> Bool {
        return productImage.exists
    }
    
    /// Checks if the "Remove from Cart" button is enabled.
    ///
    /// This function returns `true` if the `removeFromCartBtn` is enabled.
    func checkRemoveButtonsEnabled() -> Bool {
        return removeFromCartButton.isEnabled
    }
    
    /// Checks if the "Proceed to Checkout" button is visible.
    ///
    /// This function returns `true` if the `proceedToCheckOutBtn` UI element is visible on the screen.
    func isProceedToCheckoutVisible() -> Bool {
        return Helpers.isUIElementVisible(proceedToCheckOutButton)
    }
}
