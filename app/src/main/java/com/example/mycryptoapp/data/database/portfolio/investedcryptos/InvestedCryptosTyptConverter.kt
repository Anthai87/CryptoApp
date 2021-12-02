package com.example.mycryptoapp.data.database.portfolio.investedcryptos

import androidx.room.TypeConverter
import com.example.mycryptoapp.models.Crypto
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class InvestedCryptosTyptConverter {
    var gson = Gson()
    @TypeConverter
    fun cryptoToString(crypto : Crypto): String{
        return gson.toJson(crypto)
    }

    @TypeConverter
    fun stringToCrypto(data: String):Crypto{
        val listType = object : TypeToken<Crypto>() {}.type
        return gson.fromJson(data, listType)
    }

}
