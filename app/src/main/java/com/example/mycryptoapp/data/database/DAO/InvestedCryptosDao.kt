package com.example.mycryptoapp.data.database.DAO

import androidx.room.*
import com.example.mycryptoapp.data.database.Entity.InvestedCryptoEntity
import com.example.mycryptoapp.models.Crypto
import com.example.mycryptoapp.models.InvestedCrypto
import kotlinx.coroutines.flow.Flow

@Dao
interface InvestedCryptosDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
     fun buyInvestedCrypto(investedCrypto : InvestedCryptoEntity)

    @Query("SELECT * FROM invested_cryptos_table ORDER BY id ASC")
    fun readInvestedCryptos():Flow<List<InvestedCryptoEntity>>

    @Query("SELECT * FROM invested_cryptos_table WHERE invested_cryptos_table.crypto =:crypto")
    fun readInvestedCrypto(crypto : Crypto):Flow<List<InvestedCryptoEntity>>

    @Update
    suspend fun updateInvestedCrypto(investedCryptoEntity: InvestedCryptoEntity)

    @Delete
    suspend fun deleteInvestedCrypto(investedCryptoEntity : InvestedCryptoEntity)

    @Query("DELETE FROM invested_cryptos_table")
    suspend fun deleteAllInvestedCryptos()
}