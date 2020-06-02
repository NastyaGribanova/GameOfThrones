package com.example.gameofthrones.data.api

import com.example.gameofthrones.data.api.models.ApiCharacters
import com.example.gameofthrones.data.api.models.CharacterApi
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface CharacterApiService {

    @GET("/api/characters")
    fun getAllCharacters(): Single<ApiCharacters>

    @GET("/api/characters?")
    fun characterByName(@Query("Name") name: String?): Single<ApiCharacters>

    @GET("/api/characters?")
    fun characterByUrl(@Query("url") url: String?): Single<CharacterApi>
}
