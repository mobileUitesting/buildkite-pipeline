//
//  ProductDetailPage.swift
//  My Demo AppUITests
//
//  Created by Sreenath Mudigonda on 05/11/24.
//

import XCTest

class ProductDetailScreen : BaseScreen{
    
    private lazy var collectionViewCell = app.collectionViews.cells.element(boundBy: 0)
    private lazy var productImage = app.images[ElementIdentifiers.PRODUCT_IMAGE_DETAILS]
    private lazy var productName = app.staticTexts[ElementIdentifiers.PRODUCT_NAME_DETAILS]
    private lazy var productCost = app.staticTexts[ElementIdentifiers.PRODUCT_COST_DETAILS]
    private lazy var productStarRating = app.buttons[ElementIdentifiers.PRODUCT_STAR_RATING_DETAILS]
    private lazy var greenColorsButton = app.buttons[ElementIdentifiers.GREEN_COLOR_BUTTON]
    private lazy var blueColorsButton = app.buttons[ElementIdentifiers.BLUE_COLOR_BUTTON]
    private lazy var increaseButton = app.buttons[ElementIdentifiers.INCREASE]
    private lazy var decreaseButton = app.buttons[ElementIdentifiers.DECREASE]
    private lazy var countLbl = app.staticTexts[ElementIdentifiers.COUNT_LABEL]
    private lazy var alert = app.alerts.element
    private lazy var addToCartButton = app.buttons[ElementIdentifiers.ADD_TO_CART_BUTTON]
    private lazy var backButton = app.buttons.element(boundBy: 0)
    
    let name = AppConstants.PRODUCT_DETAIL_SCREEN
    
    
    /// Navigates to the product detail page.
    ///
    /// This function triggers a tap action on the `collectionViewCell` UI element to navigate to the product detail page.
    func navigateToDetailPage() {
        Helpers.tapOnElement(collectionViewCell)
    }
    
    /// Checks if the product image is visible.
    ///
    /// This function returns `true` if the `productImage` UI element is visible on the screen.
    func isProductImageVisible() -> Bool {
        return Helpers.isUIElementVisible(productImage)
    }
    
    /// Checks if the product name is visible.
    ///
    /// This function returns `true` if the `productName` UI element is visible on the screen.
    func isProductNameVisible() -> Bool {
        return Helpers.isUIElementVisible(productName)
    }
    
    /// Checks if the product cost is visible.
    ///
    /// This function returns `true` if the `productCost` UI element is visible on the screen.
    func isProductCostVisible() -> Bool {
        return Helpers.isUIElementVisible(productCost)
    }
    
    /// Checks if the product star rating is visible.
    ///
    /// This function returns `true` if the `productStarRating` UI element is visible on the screen.
    func isProductStarRatingVisible() -> Bool {
        return Helpers.isUIElementVisible(productStarRating)
    }
    
    /// Checks if the product color selection button is visible.
    ///
    /// This function returns `true` if the `blueColorsBtn` UI element is visible on the screen.
    func isProductColorsButtonVisible() -> Bool {
        return Helpers.isUIElementVisible(blueColorsButton)
    }
    
    /// Checks if the "Increase" button is visible.
    ///
    /// This function returns `true` if the `increaseBtn` UI element is visible on the screen.
    func isIncreaseButtonVisible() -> Bool {
        return Helpers.isUIElementVisible(increaseButton)
    }
    
    /// Checks if the "Decrease" button is visible.
    ///
    /// This function returns `true` if the `decreaseBtn` UI element is visible on the screen.
    func isDecreaseButtonVisible() -> Bool {
        return Helpers.isUIElementVisible(decreaseButton)
    }
    
    /// Changes the product color to blue.
    ///
    /// This function taps the `blueColorsBtn` and returns `true` if the button is selected after the tap.
    func changeColorToBlue() -> Bool {
        Helpers.tapOnElement(blueColorsButton)
        return blueColorsButton.isSelected
    }
    
    /// Taps on the "Increase" button.
    ///
    /// This function triggers a tap action on the `increaseBtn` UI element to increase the product count.
    func tapOnIncreaseButton() {
        Helpers.tapOnElement(increaseButton)
        TestLogger.shared.log("\(name): \(LogMessages.TAPPED_INCREASE_BUTTON)")
    }
    
    /// Taps on the "Decrease" button.
    ///
    /// This function triggers a tap action on the `decreaseBtn` UI element to decrease the product count.
    func tapOnDecreaseBtn() {
        Helpers.tapOnElement(decreaseButton)
    }
    
    /// Gets the product count in the cart.
    ///
    /// This function returns the current product count from the `countLbl` label as an integer.
    func getProductCountInCart() -> Int {
        return Int(Helpers.getText(countLbl) ?? "0") ?? 0
    }
    
    /// Taps on the product star rating.
    ///
    /// This function triggers a tap action on the `productStarRating` UI element to interact with the rating.
    func tapOnStar() {
        Helpers.tapOnElement(productStarRating)
    }
    
    /// Checks if the alert is visible.
    ///
    /// This function returns `true` if the `alert` UI element is visible on the screen.
    func isAlertVisible() -> Bool {
        return alert.exists
    }
    
    /// Taps on the "OK" button in the alert.
    ///
    /// This function triggers a tap action on the "OK" button inside the `alert` UI element.
    func tapOnOk() {
        Helpers.tapOnElement(alert.buttons[ElementIdentifiers.OK_BUTTON])
    }
    
    /// Checks if the "Add to Cart" button is visible.
    ///
    /// This function returns `true` if the `addToCartBtn` UI element is visible on the screen.
    func isAddToCartBtnVisible() -> Bool {
        return Helpers.isUIElementVisible(addToCartButton)
    }
    
    /// Taps on the "Add to Cart" button.
    ///
    /// This function triggers a tap action on the `addToCartBtn` UI element to add the product to the cart.
    func tapOnAddToCart() {
        Helpers.tapOnElement(addToCartButton)
        TestLogger.shared.log("\(name): \(LogMessages.TAPPED_ADD_TO_CART_BUTTON)")
    }
    
    /// Gets the product price as a string.
    ///
    /// This function returns the product price from the `productCost` label.
    func getProductPrice() -> String {
        
        return Helpers.getText(productCost) ?? ""
    }
    
    /// Gets the product name as a string.
    ///
    /// This function returns the product name from the `productName` label.
    func getProductName() -> String {
        return Helpers.getText(productName) ?? ""
    }
    
    func tapOnBackButton(){
        Helpers.tapOnElement(backButton)
        TestLogger.shared.log("\(name): \(LogMessages.TAPPED_BACK_BUTTON)")
    }
    
    
}
