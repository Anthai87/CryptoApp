package com.example.mycryptoapp.viewmodels

import android.app.Application
import androidx.lifecycle.*
import com.example.mycryptoapp.repository.userPortfolioRepository
import com.example.mycryptoapp.data.database.portfolio.investedcryptos.InvestedCryptoEntity
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject
import androidx.lifecycle.MutableLiveData
import com.example.mycryptoapp.data.database.portfolio.userportfolio.UserPortfolioEntity
import com.example.mycryptoapp.models.Crypto



@HiltViewModel
class PortfolioViewModel @Inject constructor(
    private val repository : userPortfolioRepository,
    application: Application
) : AndroidViewModel(application) {

    val crypto = MutableLiveData<Crypto>()

    private val getAllInvestedCryptos : LiveData<List<InvestedCryptoEntity>> = repository.local.readInvestedCryptos
    private val userPortfolio :LiveData<UserPortfolioEntity> = repository.local.getUserPortfolio()

    //BUY A CRYPTO
    private fun buyInvestedCrypto(investedCryptoEntity: InvestedCryptoEntity) =
        viewModelScope.launch(Dispatchers.IO) {
            repository.local.insertInvestedCrypto(investedCryptoEntity)
        }

    //Sel A crypto
    private fun sellInvestedCrypto(investedCryptoEntity: InvestedCryptoEntity) =
        viewModelScope.launch(Dispatchers.IO) {
            repository.local.deleteInvestedCrypto(investedCryptoEntity)
        }

    //SEARCH CRYPTO BY NAME
    private fun findInvestedCrypto(name: String) : LiveData<InvestedCryptoEntity>{
        return repository.local.readInvestedCrypto(name)
    }



}
