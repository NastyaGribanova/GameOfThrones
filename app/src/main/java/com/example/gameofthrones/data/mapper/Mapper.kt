package com.example.gameofthrones.data.mapper

import com.example.gameofthrones.data.api.models.BookApi
import com.example.gameofthrones.data.api.models.CharacterApi
import com.example.gameofthrones.data.api.models.HouseApi
import com.example.gameofthrones.domain.model.Book
import com.example.gameofthrones.domain.model.Character
import com.example.gameofthrones.domain.model.House

fun mapBook(book: BookApi): Book {
        return with(book){
            Book(authors, characters, country, isbn, mediaType, name, numberOfPages, povCharacters, publisher, released, url)
        }
    }

fun mapCharacter(character: CharacterApi): Character {
    return with(character){
        Character(aliases, allegiances, books, born, culture, died, father, gender, mother, name, playedBy, povBooks, spouse, titles, tvSeries, url)
    }
}

fun mapHouse(house: HouseApi): House {
    return with(house){
        House(ancestralWeapons, cadetBranches, coatOfArms, currentLord, diedOut, founded, founder, heir, name, overlord, region, seats, swornMembers, titles, url, words)
    }
}
