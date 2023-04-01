package com.example.dz3_month5

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface PixaApi {

    @GET("/api/")
    fun getImage(
        @Query("q") keyWord: String,
        @Query("page") page: Int = 1,
        @Query("per_page") perPage: Int = 3,
        @Query("key") key: String = "34950121-0695c105a29b38f2abb090a6f"
    ): Call<PixaModel>
}