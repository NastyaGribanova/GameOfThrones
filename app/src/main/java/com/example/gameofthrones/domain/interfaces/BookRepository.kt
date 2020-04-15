package com.example.gameofthrones.domain.interfaces

import com.example.gameofthrones.domain.model.Book
import io.reactivex.Single

interface BookRepository {
    fun getBooks(): Single<List<Book>>
    fun bookByName(name: String): Single<Book>
}
