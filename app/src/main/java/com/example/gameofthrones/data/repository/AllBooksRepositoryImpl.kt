package com.example.gameofthrones.data.repository

import com.example.gameofthrones.data.api.BookApiService
import com.example.gameofthrones.data.mapper.mapBook
import com.example.gameofthrones.domain.interfaces.AllBooksRepository
import com.example.gameofthrones.domain.model.Book
import io.reactivex.Single
import javax.inject.Inject

class AllBooksRepositoryImpl @Inject constructor(
    private var apiService: BookApiService
) : AllBooksRepository{
    override fun getBooks(): Single<List<Book>> {
        return apiService.getAllBooks()
            .map {
                it.map {
                    mapBook(it)
                }
            }
    }

    override fun bookByName(name: String): Single<Book> {
        return apiService.bookByName(name)
            .map {
                mapBook(it)
            }
    }
}
