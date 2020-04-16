package com.example.gameofthrones.data.repository

import com.example.gameofthrones.data.api.BookApiService
import com.example.gameofthrones.data.mapper.BookMapper
import com.example.gameofthrones.domain.interfaces.BookRepository
import com.example.gameofthrones.domain.model.Book
import io.reactivex.Single
import javax.inject.Inject

class BookRepositoryImpl @Inject constructor(
    private val apiService: BookApiService,
    private val bookMapper: BookMapper
) : BookRepository {

    override fun bookByName(name: String): Single<Book> {
        return apiService.bookByName(name)
            .map {
                bookMapper.map(it)
            }
    }
}
