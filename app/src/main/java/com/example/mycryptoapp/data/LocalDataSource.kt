package com.example.mycryptoapp.data

import com.example.mycryptoapp.data.database.assets.AssetsDao
import com.example.mycryptoapp.data.database.assets.AssetsEntity
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class LocalDataSource @Inject constructor(
    private val assetsDao: AssetsDao
) {

    fun readDatabase(): Flow<List<AssetsEntity>> {
        return assetsDao.readAssets()
    }

    suspend fun insertAssets(assetsEntity: AssetsEntity) {
        assetsDao.insertAssets(assetsEntity)
    }

}