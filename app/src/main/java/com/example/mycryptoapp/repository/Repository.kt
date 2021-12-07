package com.example.mycryptoapp.repository

import com.example.mycryptoapp.data.database.localdatasource.AssetsLocalDataSource
import com.example.mycryptoapp.data.RemoteDataSource
import dagger.hilt.android.scopes.ActivityRetainedScoped
import javax.inject.Inject

@ActivityRetainedScoped
class Repository @Inject constructor(
    remoteDataSource: RemoteDataSource,
    assetsLocalDataSource: AssetsLocalDataSource
){

    val remote = remoteDataSource
    val local = assetsLocalDataSource

}