package com.example.myapplication.API

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiClient {

        var retrofit = Retrofit.Builder()
            .baseUrl("https://13.244.243.129")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        fun <T> buildApiClient(apiInterface: Class<T>): T {
            return retrofit.create(apiInterface)
        }
    }
