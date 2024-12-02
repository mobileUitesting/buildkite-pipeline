package com.saucelabs.mydemoapp.android.utils

import java.io.InputStream
import java.util.Properties

/**
 * This class contains methods for reading properties files.
 *
 * @author arun.pareek
 */
class PropertyParser {
     private var properties: Properties? =null

    /**
     * This is constructor
     * @param fileName
     */
    constructor(fileName: String) {
        properties = Properties()
        loadProperties(fileName)
    }

    // This is Private Constructor
    private constructor()

    /**
     * This method loads properties file.
     * @param propertyFilePath
     */
    private fun loadProperties(fileName: String) {
               try {
            val inputStream: InputStream? =
                this::class.java.classLoader?.getResourceAsStream(fileName)
                   properties?.load(inputStream)

        } catch (e: Exception) {
            e.printStackTrace() // Log the exception
        }

    }


    /**
     * This method returns value from the properties file base on given key.
     * @param key
     * @return
     */
    fun getPropertyValue(key: String?): String {
        return properties!!.getProperty(key)
    }
}
