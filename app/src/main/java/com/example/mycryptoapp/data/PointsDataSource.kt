package com.example.mycryptoapp.data

import com.example.mycryptoapp.data.database.AssetsDao
import com.example.mycryptoapp.data.database.DAO.InvestedCryptosDao
import com.example.mycryptoapp.data.database.DAO.UserPortfolioDao

import com.example.mycryptoapp.data.database.Entity.InvestedCryptoEntity
import com.example.mycryptoapp.data.database.Entity.UserPortfolioEntity
import com.example.mycryptoapp.models.Crypto
import com.example.mycryptoapp.models.UserPortfolio
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class PointsDataSource @Inject constructor(
    private val userPortfolioDao: UserPortfolioDao,
    private val investedCryptosDao: InvestedCryptosDao
) {
    //INVESTED CRYPTOS TABLE
    fun readInvestedCryptos(): Flow<List<InvestedCryptoEntity>> {
        return investedCryptosDao.readInvestedCryptos()
    }

    fun readInvestedCryptos(crypto: Crypto): Flow<List<InvestedCryptoEntity>> {
        return investedCryptosDao.readInvestedCrypto(crypto)

    }

    suspend fun deleteAllInvestedCrypto() {
        investedCryptosDao.deleteAllInvestedCryptos()
    }

    suspend fun updateInvestedCrypto(investedCrypto: InvestedCryptoEntity) {
        investedCryptosDao.updateInvestedCrypto(investedCrypto)
    }


    fun buyInvestedCrypto(investedCryptoEntity: InvestedCryptoEntity) {
        investedCryptosDao.buyInvestedCrypto(investedCryptoEntity)

    }

    suspend fun deleteInvestedCrypto(investedCryptoEntity: InvestedCryptoEntity) {
        investedCryptosDao.deleteInvestedCrypto(investedCryptoEntity)

    }

    //Userportfolio Table

    fun getUserPoints(): Double {
        return userPortfolioDao.getUserPoints()
    }



    fun updateUserPoints(points: Double) {
        userPortfolioDao.updatepoints(points)

    }


}