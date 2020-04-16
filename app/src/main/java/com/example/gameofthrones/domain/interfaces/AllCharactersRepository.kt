package com.example.gameofthrones.domain.interfaces

import io.reactivex.Single
import com.example.gameofthrones.domain.model.Character

interface AllCharactersRepository {
    fun getCharacters(): Single<List<Character>>
    fun characterByName(name: String): Single<Character>
}
