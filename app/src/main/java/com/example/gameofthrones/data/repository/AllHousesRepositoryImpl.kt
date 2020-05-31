package com.example.gameofthrones.data.repository

import com.example.gameofthrones.data.api.HouseApiService
import com.example.gameofthrones.data.mapper.mapHouse
import com.example.gameofthrones.data.mapper.mapHouses
import com.example.gameofthrones.domain.interfaces.AllHousesRepository
import com.example.gameofthrones.domain.model.House
import io.reactivex.Single
import javax.inject.Inject

class AllHousesRepositoryImpl @Inject constructor(
    private var apiService: HouseApiService
): AllHousesRepository {

    override fun getHouses(): Single<ArrayList<House>> {
        return apiService.getAllHouses()
            .map {
                    mapHouses(it)
            }
    }

    override fun houseByName(name: String): Single<ArrayList<House>> {
        return apiService.houseByName(name)
            .map {
                mapHouses(it)
            }
    }
}
