package com.example.d4aspostrecitos.di

import com.example.d4aspostrecitos.data.remote.AuthApiService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitModule {

    private const val BASE_URL = "http://192.168.1.3:9090/"  // tu URL real

    val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val authApiService: AuthApiService by lazy {
        retrofit.create(AuthApiService::class.java)
    }
}