package com.example.gameofthrones.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class City (
    @PrimaryKey
    var id: String,
    var city: String,
    var region: String
)
