//
//  TestLogger.swift
//  My Demo AppUITests
//
//  Created by Sreenath Mudigonda on 14/11/24.
//

import Foundation

class TestLogger {
    
    static let shared = TestLogger()
    private var logMessages: [String] = []
    private let fileManager = FileManager.default
    private let logFileName = "TestLog.txt"
    
    // The directory to save the log file (in the test's temporary directory)
    private var logFileURL: URL? {
        let testDirectoryURL = fileManager.temporaryDirectory
        return testDirectoryURL.appendingPathComponent(logFileName)
    }
    
    private init() {}
    
    // Function to add a message to the log
    func log(_ message: String) {
        let timestamp = getCurrentTimestamp()
        let logMessage = "[\(timestamp)] \(message)"
        logMessages.append(logMessage)
        print(logMessage) // Also print to console
    }
    
    // Function to retrieve the log file URL
    func getLogFileURL() -> URL? {
        return logFileURL
    }
    
    // Save the log messages to a file
    func saveLogToFile() {
        guard let logFileURL = logFileURL else { return }
        
        let logContent = logMessages.joined(separator: "\n")
        
        do {
            // If the file exists, overwrite it
            let isLoggerEnabled = ProcessInfo.processInfo.environment[AppConstants.ENABLE_LOGGER] ?? ""
           if isLoggerEnabled == "YES"{
                try logContent.write(to: logFileURL, atomically: true, encoding: .utf8)
                print("Log saved to file: \(logFileURL.path)")
            } else{
                print("Logger disabled")
            }
        } catch {
            print("Failed to save log file: \(error)")
        }
    }
    
    // Function to clear the log for the next run
    func clearLog() {
        logMessages.removeAll()
    }
    
    // Helper function to get the current timestamp for logging
    private func getCurrentTimestamp() -> String {
        let dateFormatter = DateFormatter()
        dateFormatter.dateFormat = "yyyy-MM-dd HH:mm:ss"
        return dateFormatter.string(from: Date())
    }
}
