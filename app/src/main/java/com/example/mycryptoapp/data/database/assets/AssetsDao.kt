package com.example.mycryptoapp.data.database.assets

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface AssetsDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAssets(assetsEntity: AssetsEntity)

    @Query("SELECT * FROM assets_table ORDER BY id ASC")
    fun readAssets(): Flow<List<AssetsEntity>>

}