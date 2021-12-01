package com.example.mycryptoapp.data.database.transactions

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters

@Database(
    entities = [TransactionsEntity::class],
    version = 1,
    exportSchema = false
)
@TypeConverters(TransactionsTypeConverter::class)
abstract class TransactionsDatabase: RoomDatabase() {

    abstract fun transactionsDao(): TransactionsDao

}