//
//  CheckoutCompleteScreen.swift
//  My Demo AppUITests
//
//  Created by Sreenath Mudigonda on 26/11/24.
//

import XCTest

class CheckoutCompleteScreen: BaseScreen {

    private lazy var continueShoppingButton = app.buttons[ElementIdentifiers.CONTINUE_SHOPPING]
    
    /// Checks if the "Continue Shopping" button is visible.
    ///
    /// This function returns `true` if the `continueShoppingButton` UI element is visible on the screen.
    func checkForContinueShoppingButton() -> Bool {
        return Helpers.isUIElementVisible(continueShoppingButton)
    }
    
    /// Taps on the "Continue Shopping" button.
    ///
    /// This function triggers a tap action on the `continueShoppingButton` UI element.
    func tapOnCotinueShoppingButton() {
        Helpers.tapOnElement(continueShoppingButton)
    }
}
