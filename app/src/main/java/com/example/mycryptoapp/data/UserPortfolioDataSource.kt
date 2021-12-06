package com.example.mycryptoapp.data

import androidx.lifecycle.LiveData
import com.example.mycryptoapp.data.database.portfolio.investedcryptos.InvestedCryptosDao
import com.example.mycryptoapp.data.database.portfolio.userportfolio.UserPortfolioDao
import com.example.mycryptoapp.data.database.portfolio.investedcryptos.InvestedCryptoEntity
import com.example.mycryptoapp.data.database.portfolio.userportfolio.UserPortfolioEntity
import com.example.mycryptoapp.models.InvestedCrypto
import javax.inject.Inject

class UserPortfolioDataSource @Inject constructor(
    private val userPortfolioDao: UserPortfolioDao,
    private val investedCryptosDao: InvestedCryptosDao
) {
    //INVESTED CRYPTOS TABLE
    val readInvestedCryptos: LiveData<List<InvestedCryptoEntity>> =
        investedCryptosDao.readInvestedCryptos()

    suspend fun deleteAllInvestedCrypto() {
        investedCryptosDao.deleteAllInvestedCryptos()
    }
    suspend fun updateInvestedCrypto(investedCrypto: InvestedCryptoEntity) {
        investedCryptosDao.updateInvestedCrypto(investedCrypto)
    }
    suspend fun insertInvestedCrypto(investedCrypto: InvestedCrypto) {
         val investedCryptoEntity=InvestedCryptoEntity(investedCrypto)
        investedCryptosDao.insertInvestedCrypto(investedCryptoEntity)
    }
    suspend fun deleteInvestedCrypto(investedCryptoEntity: InvestedCryptoEntity) {
        investedCryptosDao.deleteInvestedCrypto(investedCryptoEntity)

    }
    //Userportfolio Table
    fun getUserPortfolio(): LiveData<UserPortfolioEntity> {
        return userPortfolioDao.getUserPortfolio()
    }

}