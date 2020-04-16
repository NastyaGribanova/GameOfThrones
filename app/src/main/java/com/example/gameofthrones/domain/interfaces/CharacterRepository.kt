package com.example.gameofthrones.domain.interfaces

import com.example.gameofthrones.domain.model.Character
import io.reactivex.Single

interface CharacterRepository {
    fun characterByName(name: String): Single<Character>
}
