package com.example.gameofthrones.data.api

import com.example.gameofthrones.data.api.models.ApiBooks
import com.example.gameofthrones.data.api.models.BookApi
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface BookApiService {

    @GET("/api/books")
    fun getAllBooks(): Single<ApiBooks>

    @GET("/api/books?")
    fun bookByName(@Query("name") name: String?): Single<ApiBooks>
}
