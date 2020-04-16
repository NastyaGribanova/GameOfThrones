package com.example.gameofthrones.data.repository

import com.example.gameofthrones.data.api.HouseApiService
import com.example.gameofthrones.data.mapper.HouseMapper
import com.example.gameofthrones.domain.interfaces.AllHousesRepository
import com.example.gameofthrones.domain.model.House
import io.reactivex.Single

class AllHousesRepositoryImpl(
    private val apiService: HouseApiService,
    private val houseMapper: HouseMapper
): AllHousesRepository {
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
