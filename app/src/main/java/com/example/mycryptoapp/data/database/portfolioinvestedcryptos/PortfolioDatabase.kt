package com.example.mycryptoapp.data.database.portfolioinvestedcryptos


import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters


@Database(
    entities = [PortfolioEntity::class],
    version = 1,
    exportSchema = false
)
@TypeConverters(
    PortfolioTypeConverter::class,
)
abstract class PortfolioDatabase : RoomDatabase() {

    abstract fun portfolioDao(): PortfolioDao

}
