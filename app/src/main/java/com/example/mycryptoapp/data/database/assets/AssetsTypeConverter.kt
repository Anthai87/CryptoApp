package com.example.mycryptoapp.data.database.assets

import androidx.room.TypeConverter
import com.example.mycryptoapp.models.Assets
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class AssetsTypeConverter {

    var gson = Gson()

    @TypeConverter
    fun assetsToString(assets: Assets): String {
        return gson.toJson(assets)
    }

    @TypeConverter
    fun stringToAssets(data: String): Assets {
        val listType = object : TypeToken<Assets>() {}.type
        return gson.fromJson(data, listType)
    }

}