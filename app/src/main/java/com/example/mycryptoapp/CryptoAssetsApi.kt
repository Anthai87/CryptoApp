package com.example.mycryptoapp

import com.example.mycryptoapp.models.Assets
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.QueryMap

interface CryptoAssetsApi {

    @GET("v2/assets")
    fun getAssets(
        @QueryMap queries: Map<String, String>
    ): Response<Assets>

}