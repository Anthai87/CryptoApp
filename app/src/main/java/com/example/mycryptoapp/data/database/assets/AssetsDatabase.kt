package com.example.mycryptoapp.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.mycryptoapp.data.database.assets.AssetsEntity
import com.example.mycryptoapp.data.database.assets.AssetsTypeConverter
@Database(
    entities = [AssetsEntity::class],
    version = 1,
    exportSchema = false
)
@TypeConverters(
    AssetsTypeConverter::class,

)

abstract class AssetsDatabase : RoomDatabase() {
    abstract fun assetsDao(): AssetsDao

}