package com.example.gameofthrones.data.repository

import com.example.gameofthrones.data.api.CharacterApiService
import com.example.gameofthrones.data.mapper.CharacterMapper
import com.example.gameofthrones.domain.interfaces.CharacterRepository
import com.example.gameofthrones.domain.model.Character
import io.reactivex.Single

class CharacterRepositoryImpl(
    private val apiService: CharacterApiService,
    private val characterMapper: CharacterMapper
) : CharacterRepository {
    override fun getCharacters(): Single<List<Character>> {
        return apiService.getAllCharacters()
            .map {
                it.map {
                    characterMapper.map(it)
                }
            }
    }

    override fun characterByName(name: String): Single<Character> {
        return apiService.characterByName(name)
            .map {
                characterMapper.map(it)
            }
    }
}