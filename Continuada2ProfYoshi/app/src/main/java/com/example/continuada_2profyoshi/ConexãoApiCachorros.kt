package com.example.continuada_2profyoshi

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ConexãoApiCachorros {
    fun criar(): ApiCachorros{

        return Retrofit.Builder()
            .baseUrl("https://5f861cfdc8a16a0016e6aacd.mockapi.io/bandtec-api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiCachorros::class.java)
    }
}