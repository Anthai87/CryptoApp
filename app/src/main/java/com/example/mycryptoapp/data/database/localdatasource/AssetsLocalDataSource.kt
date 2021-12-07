package com.example.mycryptoapp.data.database.localdatasource

import com.example.mycryptoapp.data.database.AssetsDao
import com.example.mycryptoapp.data.database.assets.AssetsEntity
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class AssetsLocalDataSource @Inject constructor(
    private val assetsDao: AssetsDao
) {

    fun readDatabase(): Flow<List<AssetsEntity>> {
        return assetsDao.readAssets()
    }

    suspend fun insertAssets(assetsEntity: AssetsEntity) {
        assetsDao.insertAssets(assetsEntity)
    }

}