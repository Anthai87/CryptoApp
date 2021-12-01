package com.example.mycryptoapp.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.asLiveData

import com.example.mycryptoapp.data.database.assets.AssetsEntity
import com.example.mycryptoapp.data.database.transactions.TransactionsEntity
import com.example.mycryptoapp.repository.TransactionsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class TransactionsViewModel @Inject constructor(
    private val transactionsRepository: TransactionsRepository,
    application: Application
) : AndroidViewModel(application) {

    /** ROOM DATABASE */
    val readTransactions: LiveData<List<TransactionsEntity>> = transactionsRepository.local.readDatabase().asLiveData()

}



