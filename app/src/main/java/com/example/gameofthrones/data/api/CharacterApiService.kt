package com.example.gameofthrones.data.api

import com.example.gameofthrones.data.api.models.ApiCharacters
import com.example.gameofthrones.data.api.models.CharacterApi
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path

interface CharacterApiService {

    @GET("/characters")
    fun getAllCharacters(): Single<ApiCharacters>

    @GET("/characters?Name={name}")
    fun characterByName(@Path("name") name: String?): Single<CharacterApi>
}
