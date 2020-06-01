package com.example.gameofthrones.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class HouseWords (
    @PrimaryKey
    var id: String,
    var house: String,
    var words: String
)
