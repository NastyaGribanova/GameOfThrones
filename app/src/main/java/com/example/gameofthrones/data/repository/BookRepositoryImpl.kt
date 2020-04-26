package com.example.gameofthrones.data.repository

import com.example.gameofthrones.data.api.BookApiService
import com.example.gameofthrones.data.mapper.mapBook
import com.example.gameofthrones.domain.interfaces.BookRepository
import com.example.gameofthrones.domain.model.Book
import io.reactivex.Single
import javax.inject.Inject

class BookRepositoryImpl @Inject constructor(
    private var apiService: BookApiService
) : BookRepository {

    override fun bookByName(name: String): Single<Book> {
        return apiService.bookByName(name)
            .map {
                mapBook(it)
            }
    }
}
