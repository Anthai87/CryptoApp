package com.example.mycryptoapp.ui.fragments.favorites

import com.example.mycryptoapp.models.Assets
import com.example.mycryptoapp.models.Crypto
import com.robinhood.spark.SparkAdapter

class CryptoSparkAdapter(private val dailyData: List<Crypto>): SparkAdapter() {
    override fun getY(index: Int): Float {
        val chosenDayData = dailyData[index]
        return chosenDayData.marketCapUsd.toFloat()
    }

    override fun getItem(index: Int) = dailyData[index]

    override fun getCount() = dailyData.size

}