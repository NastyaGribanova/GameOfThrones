package com.example.gameofthrones.data.mapper

import com.example.gameofthrones.data.api.models.BookApi
import com.example.gameofthrones.domain.model.Book

class BookMapper {
    fun map(book: BookApi): Book {
        return with(book){
            Book(authors, characters, country, isbn, mediaType, name, numberOfPages, povCharacters, publisher, released, url)
        }
    }
}
