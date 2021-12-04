package com.example.mycryptoapp.data.database.portfolio.investedcryptos

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface InvestedCryptosDao {
    //@Query("INSERT INTO invested_cryptos_table (crypto,points)VALUES (:crypto, :points);"

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertInvestedCrypto(investedCrypto : InvestedCryptoEntity)

    @Query("SELECT * FROM invested_cryptos_table ORDER BY id ASC")
    fun readInvestedCryptos(): LiveData<List<InvestedCryptoEntity>>

    @Query("SELECT * FROM invested_cryptos_table WHERE invested_cryptos_table.name =:name")
    fun readInvestedCrypto(name : String):LiveData<InvestedCryptoEntity>

    @Update
    suspend fun updateInvestedCrypto(investedCryptoEntity: InvestedCryptoEntity)

    @Delete
    suspend fun deleteInvestedCrypto(investedCryptoEntity : InvestedCryptoEntity)

    @Query("DELETE FROM invested_cryptos_table")
    suspend fun deleteAllInvestedCryptos()
}