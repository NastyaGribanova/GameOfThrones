package com.example.gameofthrones.domain.interfaces

import io.reactivex.Single
import com.example.gameofthrones.domain.model.Character

interface AllCharactersRepository {
    fun getCharacters(): Single<ArrayList<Character>>
    fun characterByName(name: String): Single<ArrayList<Character>>
}
