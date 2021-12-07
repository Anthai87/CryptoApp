package com.example.mycryptoapp.logic

import com.example.mycryptoapp.models.Crypto
import com.example.mycryptoapp.models.InvestedCrypto
import com.example.mycryptoapp.models.Portfolio
import com.example.mycryptoapp.models.Transactions
import java.math.BigDecimal
import java.math.RoundingMode
import kotlin.math.ceil
import kotlin.math.roundToInt
import kotlin.math.roundToLong

object PortfolioLogic {

    var portfolioAmount = 10000.0
    var list = Portfolio(listOf(
        InvestedCrypto(Crypto("","","","","","","1234","","","btc","",""), 55.5),
        InvestedCrypto(Crypto("","","","","","","1234","","","eth","",""), 50.5),),
        portfolioAmount)


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