//
//  VerificationManager.swift
//  My Demo AppUITests
//
//  Created by Sreenath Mudigonda on 14/11/24.
//

import XCTest

class VerificationManager {

    // Verifies if the given XCUIElement exists in the UI.
    static func varifyExistance(for element: XCUIElement) {
        XCTAssertTrue(element.exists)
    }

    // Verifies that the actual text matches the expected text.
    // Optionally, a custom message can be provided.
    static func verifyText(actualText: String, expectedText: String, message: String = "") {
        XCTAssertEqual(actualText, expectedText, message)
    }

    // Verifies that the given boolean statement is true.
    static func verifyBool(for statement: Bool) {
        if statement == true{
            XCTAssertTrue(statement)
        } else{
            XCTFail()
        }
    }
}
