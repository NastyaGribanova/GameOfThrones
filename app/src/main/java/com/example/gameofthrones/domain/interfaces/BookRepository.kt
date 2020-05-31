package com.example.gameofthrones.domain.interfaces

import com.example.gameofthrones.domain.model.Book
import io.reactivex.Single

interface BookRepository {
    fun bookByName(name: String): Single<ArrayList<Book>>
}
