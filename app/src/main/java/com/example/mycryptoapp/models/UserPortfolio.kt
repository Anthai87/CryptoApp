package com.example.mycryptoapp.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class UserPortfolio(
    @SerializedName("points")
    val points:Double=200.0
): Parcelable