package com.saucelabs.mydemoapp.android.data.model

data class ColorModel(private var colorImg: Int, private var colorValue: Int) {

    fun getColorImg(): Int {
        return colorImg
    }

    fun setColorImg(colorImg: Int) {
        this.colorImg = colorImg
    }

    fun getColorValue(): Int {
        return colorValue
    }

    fun setColorValue(colorValue: Int) {
        this.colorValue = colorValue
    }
}

