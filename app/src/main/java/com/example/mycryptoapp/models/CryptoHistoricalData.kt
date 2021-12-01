package com.example.mycryptoapp.models

import com.google.gson.annotations.SerializedName

class CryptoHistoricalData(
    @SerializedName("id") val assetID: String,
    @SerializedName("interval") val interval: String,

    )




