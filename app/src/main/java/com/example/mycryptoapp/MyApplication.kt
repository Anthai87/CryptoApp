package com.example.mycryptoapp

import android.app.Application
import com.example.mycryptoapp.util.Constants.Companion.DATABASE_NAME
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class MyApplication: Application() {

    override fun onCreate() {
        super.onCreate()

        deleteDatabase(DATABASE_NAME);
    }
}