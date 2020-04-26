package com.example.gameofthrones.data.api

import com.example.gameofthrones.BuildConfig
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class ApiFactory {

    private val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BuildConfig.API_ENDPOINT)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
    }

    private val logging: HttpLoggingInterceptor = HttpLoggingInterceptor()

    private val client by lazy {
        logging.setLevel(HttpLoggingInterceptor.Level.BASIC)
        OkHttpClient().newBuilder()
            .addInterceptor(logging)
            .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
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
