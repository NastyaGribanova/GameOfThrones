package com.example.gameofthrones.data.repository

import com.example.gameofthrones.data.api.HouseApiService
import com.example.gameofthrones.data.mapper.mapHouse
import com.example.gameofthrones.domain.interfaces.HouseRepository
import com.example.gameofthrones.domain.model.House
import io.reactivex.Single
import javax.inject.Inject

class HouseRepositoryImpl @Inject constructor(
    private var apiService: HouseApiService
): HouseRepository {

    override fun houseByName(name: String): Single<House> {
        return apiService.houseByName(name)
            .map {
                mapHouse(it)
            }
    }
}
