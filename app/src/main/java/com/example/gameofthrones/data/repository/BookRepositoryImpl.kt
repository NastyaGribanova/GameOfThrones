package com.example.gameofthrones.data.repository

import com.example.gameofthrones.data.api.BookApiService
import com.example.gameofthrones.data.mappers.BookMapper
import com.example.gameofthrones.domain.interfaces.BookRepository
import com.example.gameofthrones.domain.models.Book
import io.reactivex.Single

class BookRepositoryImpl(
    private val apiService: BookApiService,
    private val bookMapper: BookMapper
) : BookRepository{
    override fun getBooks(): Single<List<Book>> {
        return apiService.getAllBooks()
            .map {
                it.map {
                    bookMapper.map(it)
                }
            }
    }

    override fun bookByName(name: String): Single<Book> {
        return apiService.bookByName(name)
            .map {
                bookMapper.map(it)
            }
    }
}
