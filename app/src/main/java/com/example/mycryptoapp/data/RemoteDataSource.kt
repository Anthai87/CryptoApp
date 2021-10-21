package com.example.mycryptoapp.data

import com.example.mycryptoapp.data.network.CryptoAssetsApi
import com.example.mycryptoapp.models.Assets
import retrofit2.Response
import javax.inject.Inject

class RemoteDataSource @Inject  constructor(
    private val cryptoAssetsApi: CryptoAssetsApi
) {

    suspend fun getAssets(queries: Map<String, String>): Response<Assets> {
        return cryptoAssetsApi.getAssets(queries)
    }
 }