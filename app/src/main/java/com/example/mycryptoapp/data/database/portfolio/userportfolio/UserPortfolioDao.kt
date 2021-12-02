package com.example.mycryptoapp.data.database.portfolio.userportfolio


import androidx.room.*

@Dao
interface UserPortfolioDao {

    @Query("UPDATE user_profile_table SET points = :points WHERE id = 0")
    fun updatepoints(points: Double)

    @Query("SELECT user_profile_table.points FROM user_profile_table WHERE id = 0")
    fun getUserPoints():Double

}