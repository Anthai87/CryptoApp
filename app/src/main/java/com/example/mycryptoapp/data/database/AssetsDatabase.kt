package com.example.mycryptoapp.data.database

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [AssetsEntity::class],
    version = 1,
    exportSchema = false
)
abstract class AssetsDatabase: RoomDatabase() {

    abstract fun assetsDao(): AssetsDao

}