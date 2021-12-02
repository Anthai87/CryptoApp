package com.example.mycryptoapp.data.database.portfolio.userportfolio

import androidx.room.TypeConverter
import com.example.mycryptoapp.models.UserPortfolio
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken


class UserProfileTypeConverter {


    var gson = Gson()

    @TypeConverter
    fun UserPortfolioToString(userPortfolio: UserPortfolio): String {
        return gson.toJson(userPortfolio)
    }

    @TypeConverter
    fun stringToUserPortfolio(data: String): UserPortfolio {
        val listType = object : TypeToken<UserPortfolio>() {}.type
        return gson.fromJson(data, listType)
    }
}


