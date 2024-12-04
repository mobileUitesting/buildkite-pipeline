//
//  UserAddressModel.swift
//  MyDemoAppUITests
//
//  Created by Sreenath Mudigonda on 28/11/24.
//

import Foundation

struct UserAddressModel : Codable{
    let fullName: String?
    let addressOne: String?
    let addressTwo: String?
    let city : String?
    let state: String?
    let zipCode : String?
    let country : String?
}
