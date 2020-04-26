package com.example.gameofthrones.data.api

import com.example.gameofthrones.data.api.models.ApiHouses
import com.example.gameofthrones.data.api.models.HouseApi
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path

interface HouseApiService {

    @GET("/api/houses")
    fun getAllHouses(): Single<ApiHouses>

    @GET("/api/houses?Name={name}")
    fun houseByName(@Path("name") name: String?): Single<HouseApi>
}
