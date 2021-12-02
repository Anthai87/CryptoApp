package com.example.mycryptoapp.repository

import com.example.mycryptoapp.data.LocalDataSource
import com.example.mycryptoapp.data.LocalDataTransactionSource
import com.example.mycryptoapp.data.RemoteDataSource
import dagger.hilt.android.scopes.ActivityRetainedScoped
import javax.inject.Inject

@ActivityRetainedScoped
class TransactionsRepository @Inject constructor(

    localDataTransactionSource: LocalDataTransactionSource

) {
    val local = localDataTransactionSource

}


