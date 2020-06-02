package com.example.gameofthrones.domain.interfaces

import com.example.gameofthrones.domain.model.House
import io.reactivex.Single

interface LevelApiRepository {
    fun getHouses(): Single<ArrayList<House>>
    fun houseByName(name: String): Single<ArrayList<House>>
}
