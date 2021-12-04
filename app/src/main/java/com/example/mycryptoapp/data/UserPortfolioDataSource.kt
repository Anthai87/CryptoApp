package com.example.mycryptoapp.data

import androidx.lifecycle.LiveData
import com.example.mycryptoapp.data.database.portfolio.investedcryptos.InvestedCryptosDao
import com.example.mycryptoapp.data.database.portfolio.userportfolio.UserPortfolioDao
import com.example.mycryptoapp.data.database.portfolio.investedcryptos.InvestedCryptoEntity
import com.example.mycryptoapp.data.database.portfolio.userportfolio.UserPortfolioEntity
import javax.inject.Inject

class UserPortfolioDataSource @Inject constructor(
    private val userPortfolioDao: UserPortfolioDao,
    private val investedCryptosDao: InvestedCryptosDao
) {
    //INVESTED CRYPTOS TABLE
    val readInvestedCryptos: LiveData<List<InvestedCryptoEntity>> =
        investedCryptosDao.readInvestedCryptos()


    fun readInvestedCrypto(name: String): LiveData<InvestedCryptoEntity> {
        return investedCryptosDao.readInvestedCrypto(name)

    }

    suspend fun deleteAllInvestedCrypto() {
        investedCryptosDao.deleteAllInvestedCryptos()
    }

    suspend fun updateInvestedCrypto(investedCrypto: InvestedCryptoEntity) {
        investedCryptosDao.updateInvestedCrypto(investedCrypto)
    }


    suspend fun insertInvestedCrypto(investedCryptoEntity: InvestedCryptoEntity) {
        investedCryptosDao.insertInvestedCrypto(investedCryptoEntity)

    }

    suspend fun deleteInvestedCrypto(investedCryptoEntity: InvestedCryptoEntity) {
        investedCryptosDao.deleteInvestedCrypto(investedCryptoEntity)

    }

    //Userportfolio Table

    fun getUserPortfolio(): LiveData<UserPortfolioEntity> {
        return userPortfolioDao.getUserPortfolio()
    }

    fun updateUserPoints(points: Double) {
        userPortfolioDao.updatepoints(points)
    }


}