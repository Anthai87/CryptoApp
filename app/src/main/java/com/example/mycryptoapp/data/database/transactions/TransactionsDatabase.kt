package com.example.mycryptoapp.data.database.transactions

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.mycryptoapp.data.database.assets.AssetsDao
import com.example.mycryptoapp.data.database.assets.AssetsEntity
import com.example.mycryptoapp.data.database.assets.AssetsTypeConverter

@Database(
    entities = [TransactionsEntity::class],
    version = 1,
    exportSchema = false
)
@TypeConverters(TransactionsTypeConverter::class)
abstract class TransactionsDatabase {
    abstract fun assetsDao(): AssetsDao

}