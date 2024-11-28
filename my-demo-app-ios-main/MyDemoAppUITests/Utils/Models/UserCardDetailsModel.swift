//
//  UserCardDetailsModel.swift
//  MyDemoAppUITests
//
//  Created by Sreenath Mudigonda on 28/11/24.
//

import Foundation

struct UserCardDetailsModel :Codable{
    let nameOnCard:String?
    let cardNumber: String?
    let expiryDate: String?
    let securityCode: String?
}
