package com.example.gameofthrones.data.api

import com.example.gameofthrones.data.api.models.ApiHouses
import com.example.gameofthrones.data.api.models.HouseApi
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface HouseApiService {

    @GET("/api/houses")
    fun getAllHouses(): Single<ApiHouses>

    @GET("/api/houses?")
    fun houseByName(@Query("Name") name: String?): Single<ApiHouses>

    @GET("/api/houses?")
    fun houseByUrl(@Query("url") url: String?): Single<HouseApi>
}
