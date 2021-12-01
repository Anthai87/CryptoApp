package com.example.mycryptoapp.data.database.transactions

import androidx.room.TypeConverter
import com.example.mycryptoapp.models.Assets
import com.example.mycryptoapp.models.Transaction
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class TransactionsTypeConverter {
    var gson = Gson()

    @TypeConverter
    fun transactionsToString(transaction: Transaction): String {
        return gson.toJson(transaction)
    }

    @TypeConverter
    fun stringToTransaction(data: String): Transaction {
        val listType = object : TypeToken<Transaction>() {}.type
        return gson.fromJson(data, listType)
    }
}