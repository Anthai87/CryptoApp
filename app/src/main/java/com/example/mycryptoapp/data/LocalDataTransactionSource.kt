package com.example.mycryptoapp.data

import com.example.mycryptoapp.data.database.transactions.TransactionsDao
import com.example.mycryptoapp.data.database.transactions.TransactionsEntity
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class LocalDataTransactionSource @Inject constructor(
    private val transactionsDao: TransactionsDao
) {
    fun readDatabase(): Flow<List<TransactionsEntity>> {
        return transactionsDao.readTransactions()
    }

    suspend fun insertAssets(transactionsEntity: TransactionsEntity) {
        transactionsDao.insertTransactions(transactionsEntity)
    }
}