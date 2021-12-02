package com.example.mycryptoapp.viewmodels

import android.app.Application
import android.content.Context
import androidx.lifecycle.*
import com.example.mycryptoapp.data.PointsRepository
import com.example.mycryptoapp.data.database.Entity.InvestedCryptoEntity
import com.example.mycryptoapp.data.database.Entity.UserPortfolioEntity
import com.example.mycryptoapp.models.Crypto
import com.example.mycryptoapp.models.CryptoAsset
import com.example.mycryptoapp.models.InvestedCrypto
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PortfolioViewModel @Inject constructor(
    private val repository: PointsRepository,
    application: Application
) : AndroidViewModel(application) {
    val myInvestedCryptos: LiveData<List<InvestedCryptoEntity>> =
        repository.local.readInvestedCryptos().asLiveData()


    private fun buyInvestedCrypto(investedCryptoEntity: InvestedCryptoEntity) =
        viewModelScope.launch(Dispatchers.IO) {
            repository.local.buyInvestedCrypto(investedCryptoEntity)
        }

    //Sel A crypto
    private fun sellInvestedCrypto(investedCryptoEntity: InvestedCryptoEntity) =
        viewModelScope.launch(Dispatchers.IO) {
            repository.local.deleteInvestedCrypto(investedCryptoEntity)
        }
    // GET USER POINTS




    //UPDATE USER POINTS

    private fun updateUserPoints(points: Double)={
        viewModelScope.launch(Dispatchers.IO){
            repository.local.updateUserPoints(points)
        }
    }
}
