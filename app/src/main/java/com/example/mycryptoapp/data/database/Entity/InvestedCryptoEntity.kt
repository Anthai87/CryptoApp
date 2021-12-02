package com.example.mycryptoapp.data.database.Entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.mycryptoapp.models.Crypto
import com.example.mycryptoapp.util.Constants.Companion.INVESTED_TABLE

@Entity(tableName = INVESTED_TABLE)
data class InvestedCryptoEntity
    (
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null,
    @ColumnInfo(name="crypto")
    var crypto:Crypto,
    @ColumnInfo(name="amount")
    var amount:Double = 0.0,
    ) {
}
