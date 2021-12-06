package com.example.mycryptoapp.data.database.portfolio.userportfolio

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.mycryptoapp.models.UserPortfolio
import com.example.mycryptoapp.util.Constants.Companion.USER_PORTFOLIO_TABLE
@Entity(tableName = USER_PORTFOLIO_TABLE)

data class UserPortfolioEntity
    (
    var userPortfolio : UserPortfolio
) {
    @PrimaryKey(autoGenerate = false)
    var id: Int=0
}
