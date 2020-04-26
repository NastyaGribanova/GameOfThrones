package com.example.gameofthrones.data.api

import com.example.gameofthrones.data.api.models.ApiCharacters
import com.example.gameofthrones.data.api.models.CharacterApi
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path

interface CharacterApiService {

    @GET("/api/characters")
    fun getAllCharacters(): Single<ApiCharacters>

    @GET("/api/characters?Name={name}")
    fun characterByName(@Path("name") name: String?): Single<CharacterApi>
}
