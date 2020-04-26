package com.example.gameofthrones.data.repository

import com.example.gameofthrones.data.api.CharacterApiService
import com.example.gameofthrones.data.mapper.mapCharacter
import com.example.gameofthrones.domain.interfaces.CharacterRepository
import com.example.gameofthrones.domain.model.Character
import io.reactivex.Single
import javax.inject.Inject

class CharacterRepositoryImpl @Inject constructor(
    private var apiService: CharacterApiService
) : CharacterRepository {

    override fun characterByName(name: String): Single<Character> {
        return apiService.characterByName(name)
            .map {
                mapCharacter(it)
            }
    }
}
