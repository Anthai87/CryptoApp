package com.example.mycryptoapp.data.database.transactions

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.mycryptoapp.models.Transactions
import com.example.mycryptoapp.util.Constants.Companion.TRANSACTIONS_HISTORY_TABLE

@Entity(tableName = TRANSACTIONS_HISTORY_TABLE)
class TransactionsEntity(
    var transactions: Transactions
) {
    @PrimaryKey(autoGenerate = false)
    var id: Int = 0
}
