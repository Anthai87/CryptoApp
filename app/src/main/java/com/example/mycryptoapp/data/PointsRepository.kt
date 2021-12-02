package com.example.mycryptoapp.data

import dagger.hilt.android.scopes.ActivityRetainedScoped
import javax.inject.Inject

@ActivityRetainedScoped
class PointsRepository @Inject constructor(    localDataSource: PointsDataSource
){
    val local = localDataSource
}