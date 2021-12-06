package com.example.mycryptoapp.data.database.portfolio.userportfolio


import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.mycryptoapp.data.database.portfolio.investedcryptos.InvestedCryptoEntity

@Dao
interface UserPortfolioDao {
    @Update
    suspend fun updateInvestedCrypto(userPortfolioEntity: UserPortfolioEntity)

    @Query("SELECT * FROM user_profile_table WHERE id = 0")
     fun getUserPortfolio(): LiveData<UserPortfolioEntity>
}