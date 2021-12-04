package com.example.mycryptoapp.repository

import com.example.mycryptoapp.data.UserPortfolioDataSource
import dagger.hilt.android.scopes.ActivityRetainedScoped
import javax.inject.Inject

@ActivityRetainedScoped
class userPortfolioRepository @Inject constructor(localDataSource: UserPortfolioDataSource
){
    var local = localDataSource
}

