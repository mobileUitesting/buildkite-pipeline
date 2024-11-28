//
//  Untitled.swift
//  My Demo App
//
//  Created by Sreenath Mudigonda on 05/11/24.
//

import XCTest
import Foundation


class Helpers {
    
    static func isUIElementVisible(_ element: XCUIElement,wait:Double = 2) -> Bool{
        return element.waitForExistence(timeout: wait)
    }
    static func tapOnElement(_ element: XCUIElement){
        if element.exists && element.isHittable{
            element.tap()
        } else{
            XCTFail("\(element) \(ErrorMessages.DOES_NOT_EXISTS)")
        }
    }
    static func enterText(_ element: XCUIElement, text: String) {
        if element.exists && element.isHittable {
            element.tap()  // Tap to focus if necessary
            element.typeText(text)
            //  TestLogger.shared.log("entered \(text) into \(element.label)")
        } else {
            XCTFail(ErrorMessages.ELEMENT_IS_NOT_TRACEABLE)
            TestLogger.shared.log("Failed to enter text")
        }
    }
    static func getText(_ element: XCUIElement) -> String?{
        if element.exists && element.isHittable{
            TestLogger.shared.log("Fetched \(element.label)")
            return element.label
        } else{
            XCTFail("\(element) \(ErrorMessages.DOES_NOT_EXISTS)")
            TestLogger.shared.log("Fetching failed")
            return nil
        }
    }
    static func clearTextField(_ element: XCUIElement) {
        element.tap()
        let currentText = element.value as? String ?? ""
        for _ in 0..<currentText.count {
            element.typeText("\u{8}") // This is the backspace key
        }
    }
    
}
