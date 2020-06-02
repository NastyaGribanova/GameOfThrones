package com.example.gameofthrones.data.mapper

import com.example.gameofthrones.data.api.models.BookApi
import com.example.gameofthrones.data.api.models.CharacterApi
import com.example.gameofthrones.data.api.models.HouseApi
import com.example.gameofthrones.domain.model.Book
import com.example.gameofthrones.domain.model.Character
import com.example.gameofthrones.domain.model.House

fun mapBook(bookApi: ArrayList<BookApi>): ArrayList<Book> {
    val books = ArrayList<Book>()
    for (book in bookApi){
        if (book.name != "") {
            books.add(
                with(book) {
                    Book(
                        authors,
                        characters,
                        country,
                        isbn,
                        mediaType,
                        name,
                        numberOfPages,
                        povCharacters,
                        publisher,
                        released,
                        url
                    )
                }
            )
        }
    }
    return books
}

fun mapCharacters(characterApi: ArrayList<CharacterApi>): ArrayList<Character> {
    val characters = ArrayList<Character>()
    for (character in characterApi){
        if (character.name != "") {
            characters.add(
                with(character) {
                    Character(
                        aliases,
                        allegiances,
                        books,
                        born,
                        culture,
                        died,
                        father,
                        gender,
                        mother,
                        name,
                        playedBy,
                        povBooks,
                        spouse,
                        titles,
                        tvSeries,
                        url
                    )
                }
            )
        }
    }
    return characters
}

fun mapCharacter(character: CharacterApi): Character {
        return with(character){
            Character(aliases, allegiances, books, born, culture, died, father, gender, mother, name, playedBy, povBooks, spouse, titles, tvSeries, url)
        }

}

fun mapHouses(houseApi: ArrayList<HouseApi>): ArrayList<House> {
    val houses = ArrayList<House>()
    for (house in houseApi){
        if (house.name != "") {
            houses.add(
                with(house) {
                    House(ancestralWeapons, cadetBranches, coatOfArms, currentLord, diedOut, founded, founder, heir, name, overlord, region, seats, swornMembers, titles, url, words)
                }
            )
        }
    }
    return houses
}

fun mapHouse(house: HouseApi): House {
    return with(house){
        House(ancestralWeapons, cadetBranches, coatOfArms, currentLord, diedOut, founded, founder, heir, name, overlord, region, seats, swornMembers, titles, url, words)
    }
}
