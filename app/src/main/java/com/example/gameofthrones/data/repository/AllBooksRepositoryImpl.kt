package com.example.gameofthrones.data.repository

import com.example.gameofthrones.data.api.BookApiService
import com.example.gameofthrones.data.mapper.BookMapper
import com.example.gameofthrones.domain.interfaces.AllBooksRepository
import com.example.gameofthrones.domain.model.Book
import io.reactivex.Single
import javax.inject.Inject

class AllBooksRepositoryImpl @Inject constructor(
    private val apiService: BookApiService,
    private val bookMapper: BookMapper
) : AllBooksRepository{
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
