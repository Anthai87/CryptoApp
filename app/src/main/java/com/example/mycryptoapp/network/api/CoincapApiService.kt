package com.example.mycryptoapp.network.api

import com.example.mycryptoapp.network.api.model.AssetDto
import com.example.mycryptoapp.network.api.model.RateDto
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.create
import retrofit2.http.GET
import retrofit2.http.Path
import timber.log.Timber

private const val BASE_URL = "https://api.coincap.io/v2/"


interface CoincapApiService {
    @GET("rates")
    fun getRates(): Call<MutableList<RateDto>>

    @GET("rates/{id}")
    suspend fun getRate(@Path("id") id: String): RateDto

    @GET("rates/{id}")
    fun getRateAssetString(@Path("id") id: String): Call<String>

    @GET("asset/{id}")
    suspend fun getAsset(@Path("id") id: String): AssetDto

    companion object {
        fun build(): CoincapApiService =
            Retrofit.Builder()
                .baseUrl("https://api.coincap.io/v2/")
                .client(OkHttpClient.Builder()
                    .addInterceptor { chain ->
                        chain.request().newBuilder()
                            .addHeader(
                                "Authorization",
                                "Bearer 04f7de78-3810-454f-bcf5-44ce797b483e"
                            )
                            .build()
                            .let { chain.proceed(it) }
                    }
                    .addInterceptor(
                        HttpLoggingInterceptor({ Timber.d(it) })
                            .also { it.level = HttpLoggingInterceptor.Level.BODY }
                    )
                    .build()
                )
                .addConverterFactory(WrapperConverter())
                .addConverterFactory(MoshiConverterFactory.create())
                .build()
                .create()
    }
}
