package com.example.mycryptoapp.viewmodels

import android.app.Application
import androidx.lifecycle.*
import com.example.mycryptoapp.repository.UserPortfolioRepository
import com.example.mycryptoapp.data.database.portfolioinvestedcryptos.PortfolioEntity
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject
import com.example.mycryptoapp.models.Portfolio


@HiltViewModel
class PortfolioViewModel @Inject constructor(
    private val userPortfolioRepository : UserPortfolioRepository,
    application: Application
) : AndroidViewModel(application) {


    val readPortfolio: LiveData<List<PortfolioEntity>> = userPortfolioRepository.local.readPortfolio().asLiveData()


    fun offlineCachePortfolio(portfolio: Portfolio) {
        val portfolioEntity = PortfolioEntity(portfolio)
        insertTransactions(portfolioEntity)
    }

    private fun insertTransactions(portfolioEntity: PortfolioEntity) =
        /** ROOM DATABASE */
        viewModelScope.launch(Dispatchers.IO) {
            userPortfolioRepository.local.insertPortfolio(portfolioEntity)
        }

}
