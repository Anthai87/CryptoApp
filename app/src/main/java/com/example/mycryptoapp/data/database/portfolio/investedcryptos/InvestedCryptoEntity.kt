package com.example.mycryptoapp.data.database.portfolio.investedcryptos

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.mycryptoapp.models.InvestedCrypto
import com.example.mycryptoapp.util.Constants.Companion.INVESTED_TABLE

@Entity(tableName = INVESTED_TABLE)
data class InvestedCryptoEntity(
   var investedCrypto:InvestedCrypto
) {
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
}
