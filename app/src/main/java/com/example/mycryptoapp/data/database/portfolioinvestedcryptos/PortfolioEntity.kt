package com.example.mycryptoapp.data.database.portfolioinvestedcryptos

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.mycryptoapp.models.Crypto
import com.example.mycryptoapp.models.Portfolio
import com.example.mycryptoapp.util.Constants.Companion.PORTFOLIO_TABLE

@Entity(tableName = PORTFOLIO_TABLE)
data class PortfolioEntity(
    var portfolio: Portfolio
) {
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
}
