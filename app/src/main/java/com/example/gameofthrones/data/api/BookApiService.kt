package com.example.gameofthrones.data.api

import com.example.gameofthrones.data.api.models.ApiBooks
import com.example.gameofthrones.data.api.models.BookApi
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path

interface BookApiService {

    @GET("/api/books")
    fun getAllBooks(): Single<ApiBooks>

    @GET("/api/books?Name={name}")
    fun bookByName(@Path("name") name: String?): Single<BookApi>
}
