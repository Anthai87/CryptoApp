package com.example.mycryptoapp.data.database.localdatasource

import androidx.lifecycle.LiveData
import com.example.mycryptoapp.data.database.portfolioinvestedcryptos.PortfolioDao
import com.example.mycryptoapp.data.database.portfolioinvestedcryptos.PortfolioEntity
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class PortfolioLocalDataSource @Inject constructor(
    private val portfolioDao: PortfolioDao
) {

    fun readPortfolio(): Flow<List<PortfolioEntity>> =
        portfolioDao.readInvestedCryptos()

    suspend fun insertPortfolio(portfolioEntity: PortfolioEntity) {
        portfolioDao.insertInvestedCrypto(portfolioEntity)

    }

}