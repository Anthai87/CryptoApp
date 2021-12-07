package com.example.mycryptoapp.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.example.mycryptoapp.data.database.transactions.TransactionsEntity
import com.example.mycryptoapp.models.Transactions
import com.example.mycryptoapp.repository.TransactionsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TransactionsViewModel @Inject constructor(private val transactionsRepository: TransactionsRepository, application: Application) : AndroidViewModel(application) {

    /** ROOM DATABASE */
    val readTransactions: LiveData<List<TransactionsEntity>> = transactionsRepository.local.readDatabase().asLiveData()


    fun offlineCacheTransaction(transactions: Transactions) {
        val transactionsEntity = TransactionsEntity(transactions)
        insertTransactions(transactionsEntity)
    }

    private fun insertTransactions(transactionsEntity: TransactionsEntity) =
        /** ROOM DATABASE */
        viewModelScope.launch(Dispatchers.IO) {
            transactionsRepository.local.insertTransactions(transactionsEntity)
        }




}



