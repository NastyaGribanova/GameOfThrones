package com.example.gameofthrones.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class BooksData (
    @PrimaryKey
    var id: String,
    var book: String,
    var date: String
)
