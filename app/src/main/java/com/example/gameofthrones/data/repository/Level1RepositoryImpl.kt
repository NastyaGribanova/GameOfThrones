package com.example.gameofthrones.data.repository

import com.example.gameofthrones.data.api.HouseApiService
import com.example.gameofthrones.data.mapper.mapHouses
import com.example.gameofthrones.domain.interfaces.AllHousesRepository
import com.example.gameofthrones.domain.interfaces.Level1Repository
import com.example.gameofthrones.domain.model.House
import io.reactivex.Single
import javax.inject.Inject

class Level1RepositoryImpl @Inject constructor(
    private var apiService: HouseApiService
): Level1Repository {

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
