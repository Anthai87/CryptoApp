package com.example.mycryptoapp.data.database.portfolio.userportfolio


import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.mycryptoapp.data.database.portfolio.investedcryptos.InvestedCryptosDao
import com.example.mycryptoapp.data.database.portfolio.investedcryptos.InvestedCryptoEntity
import com.example.mycryptoapp.data.database.portfolio.investedcryptos.InvestedCryptosTyptConverter
import com.example.mycryptoapp.util.Constants.Companion.PORTFOLIO_DATABASE_NAME
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


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
