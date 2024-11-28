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
        } else {
            XCTFail(ErrorMessages.ELEMENT_IS_NOT_TRACEABLE)
        }
    }
    static func getText(_ element: XCUIElement) -> String?{
        if element.exists && element.isHittable{
            return element.label
        } else{
            XCTFail("\(element) \(ErrorMessages.DOES_NOT_EXISTS)")
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
    static func loadTestData<T: Decodable>(from fileName: String, ofType type: T.Type = T.self) -> T? {
        guard let url = Bundle(for: BaseTest.self).url(forResource: fileName, withExtension: "json") else {
            print(ErrorMessages.TEST_DATA_NOT_FOUND)
            return nil
        }
        do {
            // Load the data from the file
            let data = try Data(contentsOf: url)
            let decoder = JSONDecoder()
            let decodedData = try decoder.decode(T.self, from: data)
            return decodedData
        } catch {
            print("\(ErrorMessages.FAILED_TO_LOAD): \(error)")
            return nil
        }
    }
}
