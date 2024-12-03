//
//  SessionManager.swift
//  MyDemoAppUITests
//
//  Created by Sreenath Mudigonda on 03/12/24.
//

import Foundation
import XCTest


class SessionManager {
    static let shared = SessionManager()
    
    var app = XCUIApplication()
   
    
    func startSession() {
        app.launch()
    }
    
    func endSession() {
        app.terminate()
    }
}
