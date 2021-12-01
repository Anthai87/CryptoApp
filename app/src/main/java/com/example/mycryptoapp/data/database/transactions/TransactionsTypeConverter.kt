package com.example.mycryptoapp.data.database.transactions

import androidx.room.TypeConverter
import com.example.mycryptoapp.models.Assets
import com.example.mycryptoapp.models.Transaction
import com.example.mycryptoapp.models.Transactions
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class TransactionsTypeConverter {
    var gson = Gson()

    @TypeConverter
    fun transactionsToString(transactions: Transactions): String {
        return gson.toJson(transactions)
    }

    @TypeConverter
    fun stringToTransaction(data: String): Transactions {
        val listType = object : TypeToken<Transactions>() {}.type
        return gson.fromJson(data, listType)
    }
}