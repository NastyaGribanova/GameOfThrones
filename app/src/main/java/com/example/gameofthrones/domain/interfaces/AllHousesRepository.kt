package com.example.gameofthrones.domain.interfaces

import com.example.gameofthrones.domain.model.House
import io.reactivex.Single

interface AllHousesRepository {
    fun getHouses(): Single<List<House>>
    fun houseByName(name: String): Single<House>
}
