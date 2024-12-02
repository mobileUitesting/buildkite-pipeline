//
//  BaseTest.swift
//  My Demo AppUITests
//
//  Created by Sreenath Mudigonda on 06/11/24.
//

import XCTest

class BaseTest: XCTestCase {
    
    var app: XCUIApplication!
    
    override func setUp() {
        super.setUp()
        app = XCUIApplication()
        app.launch()
    }
    
    override func tearDown() {
        app.terminate()
        super.tearDown()
        TestLogger.shared.saveLogToFile()
        if let logFileURL = TestLogger.shared.getLogFileURL() {
            print("Log file URL: \(logFileURL.path)")
        }
        
    }
}
