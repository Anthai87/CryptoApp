package com.example.mycryptoapp.logic

import com.example.mycryptoapp.models.Transaction
import com.example.mycryptoapp.models.Transactions

object TransactionList {
    var list = Transactions(
        listOf(
            Transaction("sold", "0.001 BTC for 54.00 USD", "btc", 432532215),
            Transaction("sold01", "0.001 BTC for 54.00 USD", "eth", 432532215),
        )
    )
}