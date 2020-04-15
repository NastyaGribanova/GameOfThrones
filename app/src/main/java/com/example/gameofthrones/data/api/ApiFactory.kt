package com.example.gameofthrones.data.api

import com.example.gameofthrones.BuildConfig
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

object ApiFactory {

    private val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BuildConfig.API_ENDPOINT)
            .client()
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
    }

    val characterApiService: CharacterApiService by lazy {
        retrofit.create(
            CharacterApiService::class.java)
    }

    val bookApiService: BookApiService by lazy {
        retrofit.create(
            BookApiService::class.java)
    }

    val houseApiService: HouseApiService by lazy {
        retrofit.create(
            HouseApiService::class.java)
    }
}
