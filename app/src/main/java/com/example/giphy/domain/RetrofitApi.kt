package com.example.giphy.domain

import com.example.giphy.models.GifsData
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface RetrofitApi {

    @GET("https://api.giphy.com/v1/gifs/trending?offset=0&api_key=Gc7131jiJuvI7IdN0HZ1D7nh0ow5BU6g&pingback_id=18000e4ee7992cab")
    fun getGifs(): Call<GifsData>

    @GET("https://api.giphy.com/v1/videos/search?limit=20&api_key=Gc7131jiJuvI7IdN0HZ1D7nh0ow5BU6g&pingback_id=180280e147f1dde5")
    fun searchGifs(
        @Query("q") title: String
    ): Call<GifsData>
}