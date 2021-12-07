package com.example.mycryptoapp.repository

import com.example.mycryptoapp.data.database.localdatasource.TransactionsLocalDataSource
import dagger.hilt.android.scopes.ActivityRetainedScoped
import javax.inject.Inject

@ActivityRetainedScoped
class TransactionsRepository @Inject constructor(

    transactionsLocalDataSource: TransactionsLocalDataSource

) {
    val local = transactionsLocalDataSource

}


