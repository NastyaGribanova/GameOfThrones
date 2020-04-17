package com.example.gameofthrones.data.repository

import com.example.gameofthrones.data.api.CharacterApiService
import com.example.gameofthrones.data.mapper.mapCharacter
import com.example.gameofthrones.domain.interfaces.AllCharactersRepository
import com.example.gameofthrones.domain.model.Character
import io.reactivex.Single
import javax.inject.Inject

class AllCharactersRepositoryImpl @Inject constructor(
    private val apiService: CharacterApiService
) : AllCharactersRepository {
    override fun getCharacters(): Single<List<Character>> {
        return apiService.getAllCharacters()
            .map {
                it.map {
                    mapCharacter(it)
                }
            }
    }

    override fun characterByName(name: String): Single<Character> {
        return apiService.characterByName(name)
            .map {
                mapCharacter(it)
            }
    }
}