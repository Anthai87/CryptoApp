package com.example.mycryptoapp.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Transaction(
    val title: String,
    var description: String,
    var symbol: String,
    var dateTime: Int
): Parcelable
