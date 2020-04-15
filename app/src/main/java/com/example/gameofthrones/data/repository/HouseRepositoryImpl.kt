package com.example.gameofthrones.data.repository

import com.example.gameofthrones.data.api.HouseApiService
import com.example.gameofthrones.data.mappers.HouseMapper
import com.example.gameofthrones.domain.interfaces.HouseRepository
import com.example.gameofthrones.domain.models.House
import io.reactivex.Single

class HouseRepositoryImpl(
    private val apiService: HouseApiService,
    private val houseMapper: HouseMapper
): HouseRepository {
    override fun getHouses(): Single<List<House>> {
        return apiService.getAllHouses()
            .map {
                it.map {
                    houseMapper.map(it)
                }
            }
    }

    override fun houseByName(name: String): Single<House> {
        return apiService.houseByName(name)
            .map {
                houseMapper.map(it)
            }
    }
}