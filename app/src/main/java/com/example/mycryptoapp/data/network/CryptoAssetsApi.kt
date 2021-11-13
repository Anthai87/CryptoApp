package com.example.mycryptoapp.data.network

import com.example.mycryptoapp.models.Assets
import com.example.mycryptoapp.models.Crypto
import com.example.mycryptoapp.models.CryptoAsset
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface CryptoAssetsApi {

    @GET("v2/assets")
    suspend fun getAssets(): Response<Assets>

    @GET("v2/assets/{cryptoName}")
    suspend fun searchCrypto(
        @Path("cryptoName") searchPath: String
    ): Response<CryptoAsset>

}