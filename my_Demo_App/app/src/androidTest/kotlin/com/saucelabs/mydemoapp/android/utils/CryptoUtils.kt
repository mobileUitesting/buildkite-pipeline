package com.saucelabs.mydemoapp.android.utils

import java.security.MessageDigest
import java.util.Base64
import javax.crypto.Cipher
import javax.crypto.KeyGenerator
import javax.crypto.SecretKey
import javax.crypto.spec.IvParameterSpec
import javax.crypto.spec.SecretKeySpec

object CryptoUtils {
    private const val ALGORITHM = "AES"

    private fun getSecretKeyFromText(text: String): SecretKeySpec {
        // Generate a SHA-256 hash from the text
        val digest = MessageDigest.getInstance("SHA-256")
        val hashedBytes = digest.digest(text.toByteArray())

        // Create the SecretKey using the first 16 bytes (128-bit) or 32 bytes (256-bit)
        // AES supports 128, 192, or 256-bit keys. Here we use SHA-256 (which gives a 256-bit hash).
        return SecretKeySpec(hashedBytes, 0, hashedBytes.size, ALGORITHM) // 32 bytes = 256-bit key
    }


    // Encrypts a plain text using the provided secret key
    fun encrypt(data: String, secretKeyText: String): String {
        val secretKey = getSecretKeyFromText(secretKeyText)
        val cipher = Cipher.getInstance(ALGORITHM)
        cipher.init(Cipher.ENCRYPT_MODE, secretKey)
        val encryptedBytes = cipher.doFinal(data.toByteArray(Charsets.UTF_8))
        return Base64.getEncoder().encodeToString(encryptedBytes)
    }

    // Decrypts an encrypted string using the provided secret key
    fun decrypt(encryptedData: String, secretKeyText: String): String {
        val secretKey = getSecretKeyFromText(secretKeyText)
        val cipher = Cipher.getInstance(ALGORITHM)
        cipher.init(Cipher.DECRYPT_MODE, secretKey)
        val decodedBytes = Base64.getDecoder().decode(encryptedData)
        val decryptedBytes = cipher.doFinal(decodedBytes)
        return String(decryptedBytes, Charsets.UTF_8)
    }
}


