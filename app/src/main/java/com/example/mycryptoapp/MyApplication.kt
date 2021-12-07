package com.example.mycryptoapp

import android.app.Application
import com.example.mycryptoapp.util.Constants.Companion.ASSETS_DATABASE_NAME
import com.example.mycryptoapp.util.Constants.Companion.PORTFOLIO_DATABASE_NAME
import com.example.mycryptoapp.util.Constants.Companion.TRANSACTIONS_DATABASE_NAME
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class MyApplication: Application() {

    override fun onCreate() {
        super.onCreate()

        //deleteDatabase(ASSETS_DATABASE_NAME); //todo
        //deleteDatabase(TRANSACTIONS_DATABASE_NAME)
        //deleteDatabase(PORTFOLIO_DATABASE_NAME)
    }
}