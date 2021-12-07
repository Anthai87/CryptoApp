package com.example.mycryptoapp.data.database.portfolioinvestedcryptos

import androidx.room.TypeConverter
import com.example.mycryptoapp.models.InvestedCrypto
import com.example.mycryptoapp.models.Portfolio
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class PortfolioTypeConverter {
    var gson = Gson()

    @TypeConverter
    fun cryptoToString(portfolio : Portfolio): String{
        return gson.toJson(portfolio)
    }

    @TypeConverter
    fun stringToCrypto(data: String):Portfolio{
        val listType = object : TypeToken<Portfolio>() {}.type
        return gson.fromJson(data, listType)
    }


}
