package com.example.mycryptoapp.di

import android.content.Context
import androidx.room.Room
import com.example.mycryptoapp.data.database.assets.AssetsDatabase
import com.example.mycryptoapp.data.database.transactions.TransactionsDatabase
import com.example.mycryptoapp.util.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object DatabaseTransactionsModule {

    @Singleton
    @Provides
    fun provideDatabase(
        @ApplicationContext context: Context
    ) = Room.databaseBuilder(
        context,
        TransactionsDatabase::class.java,
        Constants.DATABASE_NAME_SQLITE
    ).build()

    @Singleton
    @Provides
    fun provideDao(database: TransactionsDatabase) = database.transactionsDao()
}