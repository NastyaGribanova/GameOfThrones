package com.example.gameofthrones.data.api

import com.example.gameofthrones.data.api.*
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {

    @GET("/characters")
    fun getAllCharacters(): Observable<Api?>

    @GET("/characters?Name={name}")
    fun characterByName(@Path("name") name: String?): Observable<ApiItem?>

    @GET("/houses")
    fun getAllHouses(): Observable<ApiHouses?>

    @GET("/houses?Name={name}")
    fun houseByName(@Path("name") name: String?): Observable<ApiHousesItem?>

    @GET("/books")
    fun getAllBooks(): Observable<ApiBooks?>

    @GET("/books?Name={name}")
    fun bookByName(@Path("name") name: String?): Observable<ApiBooksItem?>
}