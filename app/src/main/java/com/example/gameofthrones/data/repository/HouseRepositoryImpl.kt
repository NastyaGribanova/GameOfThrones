package com.example.gameofthrones.data.repository

import com.example.gameofthrones.data.api.HouseApiService
import com.example.gameofthrones.data.mapper.HouseMapper
import com.example.gameofthrones.domain.interfaces.HouseRepository
import com.example.gameofthrones.domain.model.House
import io.reactivex.Single

class HouseRepositoryImpl(
    private val apiService: HouseApiService,
    private val houseMapper: HouseMapper
): HouseRepository {

    override fun houseByName(name: String): Single<House> {
        return apiService.houseByName(name)
            .map {
                houseMapper.map(it)
            }
    }
}
