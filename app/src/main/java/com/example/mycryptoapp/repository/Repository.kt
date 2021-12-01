package com.example.mycryptoapp.repository

import com.example.mycryptoapp.data.LocalDataSource
import com.example.mycryptoapp.data.RemoteDataSource
import dagger.hilt.android.scopes.ActivityRetainedScoped
import javax.inject.Inject

@ActivityRetainedScoped
class Repository @Inject constructor(
    remoteDataSource: RemoteDataSource,
    localDataSource: LocalDataSource
){

    val remote = remoteDataSource
    val local = localDataSource

}