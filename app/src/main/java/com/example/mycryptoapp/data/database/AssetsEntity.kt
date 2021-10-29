package com.example.mycryptoapp.data.database;


import androidx.room.Entity;
import androidx.room.PrimaryKey;
import com.example.mycryptoapp.models.Assets;
import com.example.mycryptoapp.util.Constants.Companion.ASSETS_TABLE

@Entity(tableName = ASSETS_TABLE)
class AssetsEntity(
        var assets: Assets
) {
    @PrimaryKey(autoGenerate = false)
    var id: Int = 0
}
