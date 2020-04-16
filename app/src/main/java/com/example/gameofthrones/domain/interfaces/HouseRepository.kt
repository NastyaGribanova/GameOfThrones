package com.example.gameofthrones.domain.interfaces

import com.example.gameofthrones.domain.model.House
import io.reactivex.Single

interface HouseRepository {
    fun houseByName(name: String): Single<House>
}
