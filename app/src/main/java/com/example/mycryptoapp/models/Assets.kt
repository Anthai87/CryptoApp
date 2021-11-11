package com.example.mycryptoapp.models


import com.google.gson.annotations.SerializedName

data class Assets(
    @SerializedName("data")
    val cryptos: List<Crypto>,
    @SerializedName("timestamp")
    val timestamp: Long
)