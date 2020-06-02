package com.example.gameofthrones.data.api.models

import com.google.gson.annotations.SerializedName

data class BookApi(
    @SerializedName("authors")
    var authors: List<String>,
    @SerializedName("characters")
    var characters: List<String>,
    @SerializedName("country")
    var country: String,
    @SerializedName("isbn")
    var isbn: String,
    @SerializedName("mediaType")
    var mediaType: String,
    @SerializedName("name")
    var name: String,
    @SerializedName("numberOfPages")
    var numberOfPages: Int,
    @SerializedName("povCharacters")
    var povCharacters: List<Any>,
    @SerializedName("publisher")
    var publisher: String,
    @SerializedName("released")
    var released: String,
    @SerializedName("url")
    var url: String
)
