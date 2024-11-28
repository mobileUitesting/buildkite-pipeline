//
//  JSONParser.swift
//  My Demo App
//
//  Created by Sreenath Mudigonda on 14/11/24.
//
import Foundation

class JSONParser{
    
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
