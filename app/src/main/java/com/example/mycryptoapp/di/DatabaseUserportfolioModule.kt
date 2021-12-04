package com.example.mycryptoapp.di

import dagger.Module
import dagger.Provides
import androidx.room.Room
import dagger.hilt.InstallIn
import javax.inject.Singleton
import android.content.Context
import com.example.mycryptoapp.data.database.portfolio.userportfolio.UserPortfolioDatabase
import dagger.hilt.components.SingletonComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import com.example.mycryptoapp.util.Constants.Companion.PORTFOLIO_DATABASE_NAME

@Module
@InstallIn(SingletonComponent::class)
object DatabaseUserportfolioModule {


    @Singleton
    @Provides
    fun provideUserPortfolioDatabase(
        @ApplicationContext context: Context
    ) = Room.databaseBuilder(
        context,
        UserPortfolioDatabase::class.java,
        PORTFOLIO_DATABASE_NAME
    ).build()

    @Singleton
    @Provides
    fun provideUserPortfolioDao(database: UserPortfolioDatabase) = database.investedCryptosDao()

    @Singleton
    @Provides
    fun provideInvestedCryptoDAO(database: UserPortfolioDatabase) = database.userProfileDao()

}

