package com.saucelabs.mydemoapp.android.utils


fun main() {
    // Generate a secret key
    val secretKey = CryptoUtils.getSecretKeyFromText(config.secretKey)

    // Define the plain text to encrypt
    val password = "10203040"
    println("Original Text: $password")

    // Encrypt the text
    val encryptedText = CryptoUtils.encrypt(password, secretKey)
    println("Encrypted Text: $encryptedText")

    // Decrypt the text back to verify
    val decryptedText = CryptoUtils.decrypt(encryptedText, secretKey)
    println("Decrypted Text: $decryptedText")
}
