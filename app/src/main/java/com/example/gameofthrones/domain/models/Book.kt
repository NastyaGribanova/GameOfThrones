package com.example.gameofthrones.domain.models

data class Book(
    val authors: List<String>,
    var characters: List<String>,
    var country: String,
    var isbn: String,
    var mediaType: String,
    var name: String,
    var numberOfPages: Int,
    var povCharacters: List<Any>,
    var publisher: String,
    var released: String,
    var url: String
)