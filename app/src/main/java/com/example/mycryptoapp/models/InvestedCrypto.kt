package com.example.mycryptoapp.models

import android.os.Parcelable
import androidx.room.Embedded
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize
@Parcelize
data class InvestedCrypto(
    @SerializedName("name")
    var name: String?,
    @SerializedName("symbol")
    var symbol: String,
    @SerializedName("amount")
    var amount: Double=0.0
):Parcelable{

}
