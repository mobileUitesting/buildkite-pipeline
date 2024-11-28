//
//  CatalogPage.swift
//  My Demo AppUITests
//
//  Created by Sreenath Mudigonda on 04/11/24.
//

import XCTest

class HomeScreen : BaseScreen {
    var moreScreen : MoreScreen!
    var loginScreen:LoginScreen!
    var userCredentialsTestData:UserCredentialsTestDataModel!
    var productDetailScreen : ProductDetailScreen!
    
    override init(app: XCUIApplication) {
        super.init(app: app)
        moreScreen = MoreScreen(app: app)
        loginScreen = LoginScreen(app: app)
        userCredentialsTestData = JSONParser.loadTestData(from: AppConstants.LOGIN,ofType: UserCredentialsTestDataModel.self)
        productDetailScreen = ProductDetailScreen(app: app)
    }
    
    private lazy var productImage = app.collectionViews.cells.element(boundBy: 0).images[ElementIdentifiers.PRODUCT_IMAGE]
    private lazy var productName = app.collectionViews.cells.element(boundBy: 0).staticTexts[ElementIdentifiers.PRODUCT_NAME]
    private lazy var productCost = app.collectionViews.cells.element(boundBy: 0).staticTexts[ElementIdentifiers.PRODUCT_COST]
    private lazy var productStarRating = app.collectionViews.cells.element(boundBy: 0).buttons.element(boundBy: 4)
    private lazy var productFilter = app.buttons[ElementIdentifiers.PRODUCT_FILTER]
    private lazy var nameAscendingButton = app.buttons[ElementIdentifiers.NAME_ASCENDING]
    private lazy var starRatingAlert = app.alerts.element(boundBy: 0)
    private lazy var alertOkButton = app.alerts.element(boundBy: 0).buttons[ElementIdentifiers.OK_BUTTON]
    private lazy var nameDescendingButton = app.buttons[ElementIdentifiers.NAME_DESCENDING]
    private lazy var productCellItem = app.collectionViews.cells
    
    private lazy var twitter = app.buttons[ElementIdentifiers.TWITTER]
    private lazy var facebook = app.buttons[ElementIdentifiers.FACEBOOK]
    private lazy var linkedin = app.buttons[ElementIdentifiers.LINKEDIN]
    
    private lazy var collectionViewCell = app.collectionViews.cells
    /// Checks if the product image is visible.
    ///
    /// This function verifies if the `productImage` UI element is visible on the screen.
    func isProductImageVisible() -> Bool {
        return Helpers.isUIElementVisible(productImage)
    }
    
    /// Checks if the product name is visible.
    ///
    /// This function verifies if the `productName` UI element is visible on the screen.
    func isProductNameVisible() -> Bool {
        return Helpers.isUIElementVisible(productName)
    }
    
    /// Checks if the product cost is visible.
    ///
    /// This function verifies if the `productCost` UI element is visible on the screen.
    func isProductProductCostVisible() -> Bool {
        return Helpers.isUIElementVisible(productCost)
    }
    
    /// Checks if the product star rating is visible.
    ///
    /// This function verifies if the `productStarRating` UI element is visible on the screen.
    func isProductProductStarRatingVisible() -> Bool {
        return Helpers.isUIElementVisible(productStarRating)
    }
    
    /// Checks if the product filter is visible.
    ///
    /// This function verifies if the `productFilter` UI element is visible on the screen.
    func isProductProductFilterVisible() -> Bool {
        return Helpers.isUIElementVisible(productFilter)
    }
    
    /// Taps on the product filter.
    ///
    /// This function triggers a tap action on the `productFilter` UI element.
    func tapOnFilter() {
        Helpers.tapOnElement(productFilter)
    }
    
    /// Taps on the "Name Ascending" button.
    ///
    /// This function triggers a tap action on the `nameAscendingBtn` UI element.
    func tapOnNameAscendingButton() {
        Helpers.tapOnElement(nameAscendingButton)
    }
    
    /// Taps on the product star rating.
    ///
    /// This function triggers a tap action on the `productStarRating` UI element.
    func tapOnStarRating() {
        Helpers.tapOnElement(productStarRating)
    }
    
    /// Checks if the rating alert is visible.
    ///
    /// This function verifies if the `starRatingAlert` UI element is visible on the screen.
    func isRatingAlertVisible() -> Bool {
        return Helpers.isUIElementVisible(starRatingAlert)
    }
    
    /// Taps on the "OK" button in the alert.
    ///
    /// This function triggers a tap action on the `alertOkBtn` UI element.
    func tapOnAlertOkButton() {
        Helpers.tapOnElement(alertOkButton)
    }
    
    /// Taps on a product at a specific index.
    ///
    /// This function performs a tap action on a product item in the `productCellItem` list at the given index.
    func tapOnProduct(index: Int) {
        Helpers.tapOnElement(productCellItem.element(boundBy: index))
    }
    
    /// Taps on the lowest-priced product.
    ///
    /// This function applies the product filter, sorts by name in descending order, and selects the first product.
    func tapOnLowestPricedProduct() {
        tapOnFilter()
        Helpers.tapOnElement(nameDescendingButton)
        tapOnProduct(index: 0)
    }
    
    /// Logs in using the provided user credentials.
    ///
    /// This function taps on the "More" tab, then navigates to the login screen and performs the login action with the provided username and password.
    func login() {
        tapOnMoreTab()
        moreScreen.tapOnLogin()
        loginScreen.login(userName: userCredentialsTestData.validCredentials.userName ?? "", password: userCredentialsTestData.validCredentials.password ?? "")
    }
    
    /// Adds the first product to the cart and provides product details via a completion handler.
    ///
    /// This function selects the first product, increases its quantity, adds it to the cart, and calls the completion handler with the product name and price.
    func addToCart(index : Int = 0, completion: ((String, String) -> Void)? = nil) {
        tapOnProduct(index: index)
        productDetailScreen.tapOnIncreaseButton()
        completion?(productDetailScreen.getProductName(), productDetailScreen.getProductPrice())
        productDetailScreen.tapOnAddToCart()
        tapOnCartTab()
    }
    
    func addHeighestPricedItemToCart(){
        addToCart(index: 0)
    }
    
    func getItemDetails(at index : Int) -> (String,String) {
        let cell = collectionViewCell.element(boundBy: index)
        let productName = cell.staticTexts[ElementIdentifiers.PRODUCT_NAME].label
        let productCost = cell.staticTexts[ElementIdentifiers.PRODUCT_COST].label
        return (productName,productCost)
    }
    
    /// Logs out of the application.
    ///
    /// This function taps on the "More" tab and then taps on the "Log Out" option in the `moreScreen`.
    func logout() {
        tapOnMoreTab()
        moreScreen.tapOnLogOut()
    }
    
    /// Checks if the Twitter icon is visible.
    ///
    /// This function verifies if the `twitter` UI element is visible on the screen.
    func isTwitterVisible() -> Bool {
        return Helpers.isUIElementVisible(twitter)
    }
    
    /// Checks if the Facebook icon is visible.
    ///
    /// This function verifies if the `facebook` UI element is visible on the screen.
    func isFacebookVisible() -> Bool {
        return Helpers.isUIElementVisible(facebook)
    }
    
    /// Checks if the LinkedIn icon is visible.
    ///
    /// This function verifies if the `linkedin` UI element is visible on the screen.
    func isLinkedinVisible() -> Bool {
        return Helpers.isUIElementVisible(linkedin)
    }
    
    /// Taps on the Twitter icon.
    ///
    /// This function triggers a tap action on the `twitter` UI element.
    func tapOnTwitter() {
        Helpers.tapOnElement(twitter)
    }
    
    /// Taps on the Facebook icon.
    ///
    /// This function triggers a tap action on the `facebook` UI element.
    func tapOnFacebook() {
        Helpers.tapOnElement(facebook)
    }
    
    /// Taps on the LinkedIn icon.
    ///
    /// This function triggers a tap action on the `linkedin` UI element.
    func tapOnLinkedin() {
        Helpers.tapOnElement(linkedin)
    }
}
