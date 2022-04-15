package com.example.giphy.domain

object Common {
    private const val BASE_URL = "https://api.giphy.com/v1/"
    val retrofitApi: RetrofitApi
        get() = RetrofitClient.getClient(BASE_URL).create(RetrofitApi::class.java)
}