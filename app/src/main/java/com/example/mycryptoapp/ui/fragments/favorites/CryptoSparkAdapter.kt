package com.example.mycryptoapp.ui.fragments.favorites

import com.example.mycryptoapp.models.Crypto
import com.robinhood.spark.SparkAdapter

class CryptoSparkAdapter(private val dailyData: List<Crypto>, private val baseLineValue: String?) :
    SparkAdapter() {
    override fun getY(index: Int): Float {
        return dailyData[index].priceUsd.toFloat()
    }

    override fun getItem(index: Int): Crypto {
        return dailyData[index]

    }

    override fun getCount(): Int {
        return dailyData.size
    }

    override fun hasBaseLine(): Boolean {
        return true
    }

    override fun getBaseLine(): Float {
        return baseLineValue?.toFloat() ?: super.getBaseLine()
    }
}

