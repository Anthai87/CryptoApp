package com.example.mycryptoapp


import com.google.gson.annotations.SerializedName

data class CryptosAndDate(
    @SerializedName("data")
    val cryptos: List<Crypto>,
    @SerializedName("timestamp")
    val timestamp: Long
)