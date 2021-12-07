package com.example.mycryptoapp.data.database.portfolioinvestedcryptos

import androidx.lifecycle.LiveData
import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface PortfolioDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertInvestedCrypto(portfolio : PortfolioEntity)

    @Query("SELECT * FROM portfolio_table ORDER BY id ASC")
    fun readInvestedCryptos(): Flow<List<PortfolioEntity>>

}