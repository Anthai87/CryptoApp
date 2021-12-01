package com.example.mycryptoapp.data.database.transactions

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface TransactionsDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTransactions(transactionsEntity: TransactionsEntity)

    @Query("SELECT * FROM transactions_history_table") // TODO: 01-12-2021  ORDER BY date ASC 
    fun readTransactions(): Flow<List<TransactionsEntity>>

}