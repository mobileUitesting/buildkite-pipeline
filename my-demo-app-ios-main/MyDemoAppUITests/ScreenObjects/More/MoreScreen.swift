//
//  MoreScreen.swift
//  My Demo AppUITests
//
//  Created by Sreenath Mudigonda on 06/11/24.
//

import XCTest

class MoreScreen:BaseScreen {
    private lazy var loginButton = app.otherElements[ElementIdentifiers.LOGIN_BUTTON]
    private lazy var logOutButton = app.buttons[ElementIdentifiers.LOGOUT_BUTTON]
    private lazy var webViewButton = app.buttons[ElementIdentifiers.WEB_VIEW]
    private lazy var geoLocationButton = app.buttons[ElementIdentifiers.GEO_LOCATION]
    private lazy var aboutBtn = app.buttons[ElementIdentifiers.ABOUT]
    private lazy var resetAppStateButton = app.buttons[ElementIdentifiers.RESET_APP_STATE]
    private lazy var crashAppButton = app.buttons[ElementIdentifiers.CRASH_APP]
 
    private lazy var reportABug =  app.windows.children(matching: .other).element.children(matching: .other).element.children(matching: .other).element.children(matching: .other).element.children(matching: .other).element.children(matching: .other).element.children(matching: .other).element.children(matching: .other).element(boundBy: 1).children(matching: .other).element(boundBy: 4).children(matching: .button).element(boundBy: 0)

    private lazy var resetAppStateAlert = app.alerts.firstMatch
    private lazy var resetAppAlertButton = app.alerts.buttons[ElementIdentifiers.RESET_APP]
    private lazy var qrCodeScannerButton = app.buttons[ElementIdentifiers.QR_CODE_SCANNER_BUTTON]
    private lazy var drawingButton = app.buttons[ElementIdentifiers.DRAWING_BUTTON]
    private lazy var pushNotificationButton = app.buttons[ElementIdentifiers.PUSH_NOTIFICATIONS_BUTTON]
    private lazy var faceIDButton = app.buttons[ElementIdentifiers.FACE_ID_BUTTON]
    
    /// Taps on the login button.
    ///
    /// This function triggers a tap action on the `loginBtn` UI element.
    func tapOnLogin() {
        TestLogger.shared.log("\(AppConstants.MORE_SCREEN): \(LogMessages.CLICKED_ON_LOGIN)")
        Helpers.tapOnElement(loginButton)
    }
    
    /// Taps on the logout button.
    ///
    /// This function triggers a tap action on the `logOutBtn` UI element.
    func tapOnLogOut() {
        Helpers.tapOnElement(logOutButton)
    }
    
    /// Taps on the web view button.
    ///
    /// This function triggers a tap action on the `webViewBtn` UI element.
    func tapOnWebView() {
        Helpers.tapOnElement(webViewButton)
    }
    
    /// Taps on the geo-location button.
    ///
    /// This function triggers a tap action on the `geoLocationBtn` UI element.
    func tapOnGeoLocation() {
        Helpers.tapOnElement(geoLocationButton)
    }
    
    /// Taps on the "Report a Bug" button.
    ///
    /// This function triggers a tap action on the `reportABug` UI element.
    func tapOnReportABug() {
        Helpers.tapOnElement(reportABug)
    }
    
    /// Taps on the about button.
    ///
    /// This function triggers a tap action on the `aboutBtn` UI element.
    func tapOnAbout() {
        Helpers.tapOnElement(aboutBtn)
    }
    
    /// Taps on the "Crash the App" button.
    ///
    /// This function triggers a tap action on the `crashAppBtn` UI element.
    func tapOnCrashTheApp() {
        Helpers.tapOnElement(crashAppButton)
    }
    
    /// Taps on the "Reset App State" button.
    ///
    /// This function triggers a tap action on the `resetAppStateBtn` UI element.
    func tapOnResetAppState() {
        tapOnMoreTab()
        Helpers.tapOnElement(resetAppStateButton)
    }
    /// checks the reset alert
    ///
    /// This function checks  alert UI element.
    func checkForResetAppAlert() -> Bool{
        return Helpers.isUIElementVisible(resetAppStateAlert)
    }
    /// Taps on the "Reset App" button.
    ///
    /// This function triggers a tap action on the `resetAppStateBtn` on the alert.
    func tapOnResetAppOnAlert(){
        Helpers.tapOnElement(resetAppAlertButton)
    }
    
    
    func tapOnQRCodeScanner(){
        tapOnMoreTab()
        Helpers.tapOnElement(qrCodeScannerButton)
    }
    
    func tapOnDrawing(){
        tapOnMoreTab()
        Helpers.tapOnElement(drawingButton)
    }
    func tapOnPsushNotifications(){
        tapOnMoreTab()
        Helpers.tapOnElement(pushNotificationButton)
    }
    func tapOnFaceID(){
        tapOnMoreTab()
        Helpers.tapOnElement(faceIDButton)
    }
    
    
    func checkForLogOut() -> Bool {
        return Helpers.isUIElementVisible(logOutButton)
    }
}

