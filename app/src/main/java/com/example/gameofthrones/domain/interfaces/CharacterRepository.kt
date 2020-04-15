package com.example.gameofthrones.domain.interfaces

import io.reactivex.Single
import com.example.gameofthrones.domain.models.Character

interface CharacterRepository {
    fun getCharacters(): Single<List<Character>>
    fun characterByName(name: String): Single<Character>
}
