package com.example.mycryptoapp.models

import java.util.*

data class Transaction(
    var title: String,
    var description: String,
    var symbol: String,
    var date: Int
)
