package com.example.mycryptoapp.logic

import org.junit.Assert.*

import org.junit.Test

class PortfolioLogicTest {

    @Test
    fun hasEnoughMoneyToBuyCrypto() {
        val amount = 10000.0
        val moneyRequest = 11000.0

        var isEnoughMoney = PortfolioLogic.hasEnoughMoney(amount, moneyRequest)
        assertEquals(false,  isEnoughMoney) // OK
    }

    @Test
    fun howMuchCryptoCouldBuy() {
        val userRequestAmount = 10000.0
        val bitcoinPricePerUnit = 54044.0

        var bitcoinCouldBuy = PortfolioLogic.howMuchCryptoCouldBuy(userRequestAmount, bitcoinPricePerUnit)

        assertTrue(0.1850 == bitcoinCouldBuy) // Ok with four decimals
    }

    @Test
    fun howMuchMoneyCouldGetWhenSell() {
        val bitcoinAmount = 0.0555
        val bitcoinPrice = 54044.0

        val usdAmount = PortfolioLogic.howMuchMoneyCouldGetWhenSell(bitcoinAmount, bitcoinPrice)

        assertTrue(3000.0 == usdAmount) // Ok
    }
}