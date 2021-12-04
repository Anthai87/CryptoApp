package com.example.mycryptoapp.data.database.portfolio.investedcryptos

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.mycryptoapp.models.Crypto
import com.example.mycryptoapp.util.Constants.Companion.INVESTED_TABLE

@Entity(tableName = INVESTED_TABLE)
data class InvestedCryptoEntity
    (
    @PrimaryKey(autoGenerate = true)
    var inid: Int? = null,
    @Embedded
    val crypto:Crypto?,
    @ColumnInfo(name="amount")
    var amount:Double? = 0.0,
    ) {
}
