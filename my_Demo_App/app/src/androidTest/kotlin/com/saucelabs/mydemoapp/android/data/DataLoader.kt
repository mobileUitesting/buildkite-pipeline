package com.saucelabs.mydemoapp.android.data

import com.saucelabs.mydemoapp.android.data.model.CheckoutInfo
import com.saucelabs.mydemoapp.android.data.model.NewUser
import com.saucelabs.mydemoapp.android.data.model.UserCredentials
import com.saucelabs.mydemoapp.android.utils.parser.JsonParser1
import com.saucelabs.mydemoapp.android.utils.parser.PropertyParser

class DataLoader {
    private lateinit var properties : PropertyParser
    private lateinit var jsonloader:JsonParser1
    //private val props = PropertyParser("login.properties")
    fun getLoginCredentials(): UserCredentials {
        properties= PropertyParser("login.properties")
        val userEmail = properties.getPropertyValue("userEmail")
        val password = properties.getPropertyValue("userPassword")

        return UserCredentials(userEmail, password)
    }

    fun getRegistrationDetails():NewUser{
        properties= PropertyParser("registration.properties")
        val fullName=properties.getPropertyValue("fullName")
        val userEmail = properties.getPropertyValue("userEmail")
        val password = properties.getPropertyValue("userPassword")
        val wrongPassword = properties.getPropertyValue("wrongPassword")
        val invalidPatternEmail = properties.getPropertyValue("invalidPatternEmail")
        return NewUser(fullName,userEmail, password,wrongPassword,invalidPatternEmail)
    }


    fun getCheckInfoDetails():CheckoutInfo {
        jsonloader=JsonParser1()
       val checkInfoList: CheckoutInfo = jsonloader.parseJson("checkOutInfo.json")
      /*  val firstName=checkInfoList.firstName
        val lastName=checkInfoList.lastName
        val address1=checkInfoList.address1
        val address2=checkInfoList.address2
        val city=checkInfoList.city
        val state=checkInfoList.state
        val zip=checkInfoList.zip
        val country=checkInfoList.country
        val cardHolderName=checkInfoList.cardHolderName
        val cardNumber=checkInfoList.cardNumber
        val expirationDate=checkInfoList.expirationDate
        val securityCode=checkInfoList.securityCode
        val isSameShipping=checkInfoList.isSameShipping*/
     return checkInfoList
   }
    fun getUrls(): List<String> {
        val itemsData = mutableListOf<String>()
        properties= PropertyParser("url.properties")
       /* val twiiter = properties.getPropertyValue("twitter")
        val facebook = properties.getPropertyValue("facebook")
        val linkedIn = properties.getPropertyValue("linkedin")
        itemsData.add(twiiter)*/

        itemsData.add( properties.getPropertyValue("twitter"))
        itemsData.add( properties.getPropertyValue("facebook"))
        itemsData.add( properties.getPropertyValue("linkedin"))
        return itemsData
    }
}