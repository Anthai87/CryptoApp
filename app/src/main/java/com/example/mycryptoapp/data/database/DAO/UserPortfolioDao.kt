package com.example.mycryptoapp.data.database.DAO


import androidx.room.*
import com.example.mycryptoapp.data.database.Entity.UserPortfolioEntity
import com.example.mycryptoapp.models.UserPortfolio
import kotlinx.coroutines.flow.Flow
@Dao
interface UserPortfolioDao {

    @Query("UPDATE user_profile_table SET points = :points WHERE id = 0")
    fun updatepoints(points: Double)

    @Query("SELECT user_profile_table.points FROM user_profile_table WHERE id = 0")
    fun getUserPoints():Double

}