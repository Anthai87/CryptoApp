package com.example.mycryptoapp.repository

import com.example.mycryptoapp.data.database.localdatasource.PortfolioLocalDataSource
import dagger.hilt.android.scopes.ActivityRetainedScoped
import javax.inject.Inject

@ActivityRetainedScoped
class UserPortfolioRepository @Inject constructor(localLocalDataSource: PortfolioLocalDataSource
){
    var local = localLocalDataSource
}

