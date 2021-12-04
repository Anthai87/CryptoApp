package com.example.mycryptoapp.data.database.portfolio.userportfolio


import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface UserPortfolioDao {

    @Query("UPDATE user_profile_table SET points = :points WHERE id = 0")
     fun updatepoints(points: Double)

    @Query("SELECT * FROM user_profile_table WHERE id = 0")
     fun getUserPortfolio(): LiveData<UserPortfolioEntity>

}