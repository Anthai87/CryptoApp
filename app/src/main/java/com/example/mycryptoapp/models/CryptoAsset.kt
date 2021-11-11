package com.example.mycryptoapp.models


import com.google.gson.annotations.SerializedName

data class CryptoAsset(
    @SerializedName("data")
    val crypto: Crypto,
    @SerializedName("timestamp")
    val timestamp: Long
)