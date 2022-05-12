package com.example.mycryptoapp.logic

import com.example.mycryptoapp.models.Portfolio
import java.math.BigDecimal
import java.math.RoundingMode
import kotlin.math.ceil

object PortfolioLogic {

    var portfolioAmountTotal = 10000.0
    var portfolioAmount = 10000.0
    var portfolio = Portfolio(listOf(), 10000.0)


    fun hasEnoughMoney(amount: Double, moneyRequest: Double): Boolean {
        if (amount >= moneyRequest)
            return true
        return false
    }

    fun howMuchCryptoCouldBuy(usdAmount: Double, cryptoPrice: Double): Double {
        val cryptoAmount = usdAmount / cryptoPrice
        return BigDecimal(cryptoAmount).setScale(4, RoundingMode.HALF_EVEN).toDouble()
    }

    fun howMuchMoneyCouldGetWhenSell(cryptoAmount: Double, cryptoPrice: Double): Double {
        val moneyAmount = cryptoAmount * cryptoPrice;
        return ceil(moneyAmount)
    }

}