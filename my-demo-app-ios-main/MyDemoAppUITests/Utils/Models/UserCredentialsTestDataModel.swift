//
//  UserCredentialsTestDataModel.swift
//  MyDemoAppUITests
//
//  Created by Sreenath Mudigonda on 28/11/24.
//

import Foundation

struct UserCredentialsTestDataModel : Codable{
    let staging: CredentsialDataModel
    let production: CredentsialDataModel
    let validCredentials : CredentsialDataModel
    let invalidCredentials : CredentsialDataModel
}


struct CredentsialDataModel: Codable{
    let userName: String?
    let password: String?
}
