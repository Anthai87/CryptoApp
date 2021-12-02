package com.example.mycryptoapp.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.mycryptoapp.data.database.portfolio.investedcryptos.InvestedCryptosDao
import com.example.mycryptoapp.data.database.portfolio.userportfolio.UserPortfolioDao
import com.example.mycryptoapp.data.database.portfolio.investedcryptos.InvestedCryptoEntity
import com.example.mycryptoapp.data.database.portfolio.userportfolio.UserPortfolioEntity
import com.example.mycryptoapp.data.database.portfolio.investedcryptos.InvestedCryptosTyptConverter
import com.example.mycryptoapp.data.database.portfolio.userportfolio.UserProfileTypeConverter

@Database(
    entities = [AssetsEntity::class, InvestedCryptoEntity::class, UserPortfolioEntity::class],
    version = 1,
    exportSchema = false
)
@TypeConverters(
    AssetsTypeConverter::class,
    InvestedCryptosTyptConverter::class,
    UserProfileTypeConverter::class
)

abstract class AssetsDatabase : RoomDatabase() {
    abstract fun assetsDao(): AssetsDao
    abstract fun investedCryptosDao(): InvestedCryptosDao
    abstract fun userProfileDao(): UserPortfolioDao
}