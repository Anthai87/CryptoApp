package com.example.mycryptoapp.util

class Constants {

    companion object {

        const val BASE_URL_ASSETS = "https://api.coincap.io"
        const val BASE_URL_ICONS = "https://static.coincap.io"
        const val API_KEY = "f7a3614c-90b7-437e-a163-c3601ea555cf"

        const val CRYPTO_KEY = "cryptoBundle"

        // ROOM Database
        const val DATABASE_NAME = "assets_database"
        const val PORTFOLIO_DATABASE_NAME = "portfolio_database"
        const val ASSETS_TABLE = "assets_table"
        const val INVESTED_TABLE = "invested_cryptos_table"
        const val USER_PORTFOLIO_TABLE = "user_profile_table"

        // SQLite Database
        const val DATABASE_NAME_SQLITE = "transactions"
        const val DATABASE_VERSION_SQLITE = 1
        const val TRANSACTIONS_HISTORY_TABLE = "transactions_history_table"

    }

}