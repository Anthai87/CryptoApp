package com.example.mycryptoapp.data.database.portfolio.investedcryptos

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.mycryptoapp.models.InvestedCrypto

@Dao
interface InvestedCryptosDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertInvestedCrypto(investedCryptoEntity : InvestedCryptoEntity)

    @Query("SELECT * FROM invested_cryptos_table ORDER BY id ASC")
    fun readInvestedCryptos(): LiveData<List<InvestedCryptoEntity>>


    @Update
    suspend fun updateInvestedCrypto(investedCryptoEntity: InvestedCryptoEntity)

    @Delete
    suspend fun deleteInvestedCrypto(investedCryptoEntity : InvestedCryptoEntity)

    @Query("DELETE FROM invested_cryptos_table")
    suspend fun deleteAllInvestedCryptos()
}