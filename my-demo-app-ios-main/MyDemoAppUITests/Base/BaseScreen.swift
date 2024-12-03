//
//  BaseScreen.swift
//  My Demo AppUITests
//
//  Created by Sreenath Mudigonda on 11/11/24.
//

import XCTest


class BaseScreen {
    
    var app:XCUIApplication
    
    init(app: XCUIApplication) {
        self.app = app
    }
    
    private lazy var moreTab = app.buttons[ElementIdentifiers.MORE_TAB]
    private lazy var cartTab = app.buttons[ElementIdentifiers.CART_TAB]
    private lazy var catalogTab = app.buttons[ElementIdentifiers.CATALOG_TAB]
    
    
    func tapOnMoreTab(){
        TestLogger.shared.log("\(AppConstants.BASE_SCREEN): \(LogMessages.CLICKED_ON_MORE)")
        Helpers.tapOnElement(moreTab)
    }
    
    func tapOnCartTab(){
        TestLogger.shared.log("\(AppConstants.BASE_SCREEN): \(LogMessages.CLICKED_ON_CART)")
        Helpers.tapOnElement(cartTab)
    }
    func tapOnCatalogTab(){
        TestLogger.shared.log("\(AppConstants.BASE_SCREEN): \(LogMessages.CLICKED_ON_CATALOG)")
        Helpers.tapOnElement(catalogTab)
    }
    
}

