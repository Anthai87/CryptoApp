package com.example.mycryptoapp.di

import dagger.Module
import dagger.Provides
import androidx.room.Room
import dagger.hilt.InstallIn
import javax.inject.Singleton
import android.content.Context
import dagger.hilt.components.SingletonComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import com.example.mycryptoapp.data.database.AssetsDatabase
import com.example.mycryptoapp.util.Constants.Companion.ASSETS_DATABASE_NAME

@Module
@InstallIn(SingletonComponent::class)
object DatabaseAssetsModule {

    @Singleton
    @Provides
    fun provideDatabase(
        @ApplicationContext context: Context
    ) = Room.databaseBuilder(
        context,
        AssetsDatabase::class.java,
        ASSETS_DATABASE_NAME
    ).build()

    @Singleton
    @Provides
    fun provideDao(database: AssetsDatabase) = database.assetsDao()

}