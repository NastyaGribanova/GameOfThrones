package com.example.gameofthrones.data.mappers

import com.example.gameofthrones.data.api.models.CharacterApi
import com.example.gameofthrones.domain.models.Character

class CharacterMapper {
    fun map(character: CharacterApi): Character{
        return with(character){
            Character(aliases, allegiances, books, born, culture, died, father, gender, mother, name, playedBy, povBooks, spouse, titles, tvSeries, url)
        }
    }
}