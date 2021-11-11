package com.example.mycryptoapp.data

import com.example.mycryptoapp.data.network.CryptoAssetsApi
import com.example.mycryptoapp.models.Assets
import com.example.mycryptoapp.models.Crypto
import com.example.mycryptoapp.models.CryptoAsset
import retrofit2.Response
import javax.inject.Inject

class RemoteDataSource @Inject  constructor(
    private val cryptoAssetsApi: CryptoAssetsApi
) {

    suspend fun getAssets(): Response<Assets> {
        return cryptoAssetsApi.getAssets()
    }

    suspend fun searchAssets(searchPath: String): Response<CryptoAsset> {
        return cryptoAssetsApi.searchCrypto(searchPath)
    }

 }