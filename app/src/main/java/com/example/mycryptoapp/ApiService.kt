package com.example.mycryptoapp

import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("/assets")
    fun getAssets(): Call<MutableList<PostModel>>




}