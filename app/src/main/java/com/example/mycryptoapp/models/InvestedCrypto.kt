package com.example.mycryptoapp.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize
@Parcelize
data class InvestedCrypto(
    @SerializedName("crypto")
    var crypto: Crypto,
    @SerializedName("amount")
    val amount: Double=0.0
):Parcelable
