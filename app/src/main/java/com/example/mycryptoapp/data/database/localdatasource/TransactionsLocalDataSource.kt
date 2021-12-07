package com.example.mycryptoapp.data.database.localdatasource

import com.example.mycryptoapp.data.database.transactions.TransactionsDao
import com.example.mycryptoapp.data.database.transactions.TransactionsEntity
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class TransactionsLocalDataSource @Inject constructor(
    private val transactionsDao: TransactionsDao
) {
    fun readDatabase(): Flow<List<TransactionsEntity>> {
        return transactionsDao.readTransactions()
    }

    suspend fun insertTransactions(transactionsEntity: TransactionsEntity) {
        transactionsDao.insertTransactions(transactionsEntity)
    }
}