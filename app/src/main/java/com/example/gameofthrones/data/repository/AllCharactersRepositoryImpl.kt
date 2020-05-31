package com.example.gameofthrones.data.repository

import com.example.gameofthrones.data.api.CharacterApiService
import com.example.gameofthrones.data.api.models.ApiCharacters
import com.example.gameofthrones.data.mapper.mapCharacters
import com.example.gameofthrones.domain.interfaces.AllCharactersRepository
import com.example.gameofthrones.domain.model.Character
import io.reactivex.Single
import javax.inject.Inject

class AllCharactersRepositoryImpl @Inject constructor(
    private var apiService: CharacterApiService
) : AllCharactersRepository {

    override fun getCharacters(): Single<ArrayList<Character>> {
        return apiService.getAllCharacters()
            .map {
                    mapCharacters(it)
            }
    }

    override fun characterByName(name: String): Single<ArrayList<Character>> {
        return apiService.characterByName(name)
            .map {
                mapCharacters(it)
            }
    }
}
