package com.example.mycryptoapp.data.database.portfolio.userportfolio


import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.mycryptoapp.data.database.portfolio.investedcryptos.InvestedCryptosDao
import com.example.mycryptoapp.data.database.portfolio.investedcryptos.InvestedCryptoEntity
import com.example.mycryptoapp.data.database.portfolio.investedcryptos.InvestedCryptosTyptConverter



@Database(
    entities = [InvestedCryptoEntity::class, UserPortfolioEntity::class],
    version = 1,
    exportSchema = false
)
@TypeConverters(
    InvestedCryptosTyptConverter::class,
    UserProfileTypeConverter::class
)

abstract class UserPortfolioDatabase : RoomDatabase() {

    abstract fun investedCryptosDao(): InvestedCryptosDao

    abstract fun userProfileDao(): UserPortfolioDao

}
