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
import com.example.mycryptoapp.models.InvestedCrypto


val crypto = MutableLiveData<Crypto>()


@HiltViewModel
class UserPortfolioViewModel @Inject constructor(
    private val repository : userPortfolioRepository,
    application: Application
) : AndroidViewModel(application) {

    private val allInvestedCryptos : LiveData<List<InvestedCryptoEntity>> = repository.local.readInvestedCryptos
    private val userPortfolio :LiveData<UserPortfolioEntity> = repository.local.getUserPortfolio()


    //BUY A CRYPTO
    public fun buyInvestedCrypto(investedCrypto: InvestedCrypto) =
    viewModelScope.launch(Dispatchers.IO) {
        repository.local.insertInvestedCrypto(investedCrypto)
        }
    //Sel A crypto
    private fun sellInvestedCrypto(investedCryptoEntity: InvestedCryptoEntity) =
        viewModelScope.launch(Dispatchers.IO) {
            repository.local.deleteInvestedCrypto(investedCryptoEntity)
        }


}
