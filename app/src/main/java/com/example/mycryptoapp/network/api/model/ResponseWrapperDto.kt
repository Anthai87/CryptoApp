package com.example.mycryptoapp.network.api.model

import com.squareup.moshi.JsonClass

    @JsonClass(generateAdapter = true)
    data class ResponseWrapperDto<R>(val data: R, val timestamp: Long)
