package com.example.gameofthrones.di

import com.example.gameofthrones.di.component.*

object AppInjector {

    lateinit var appComponent: AppComponent
    private var allBooksComponent: AllBooksComponent? = null
    private var bookComponent: BookComponent? = null
    private var allCharactersComponent: AllCharactersComponent? = null
    private var characterComponent: CharacterComponent? = null
    private var allHousesComponent: AllHousesComponent? = null
    private var houseComponent: HouseComponent? = null

    fun init(app: App) {
        appComponent = DaggerAppComponent.builder()
            .application(app)
            .build()
    }

    fun plusAllBooksComponent(): AllBooksComponent = allBooksComponent
        ?: appComponent.allBooksComponent()
            .build().also {
                allBooksComponent = it
            }

    fun clearAllBooksComponent() {
        allBooksComponent = null
    }

    fun plusBookComponent(): BookComponent = bookComponent
        ?: appComponent.bookComponent()
            .build().also {
                bookComponent = it
            }

    fun clearBookComponent() {
        bookComponent = null
    }

    fun plusAllCharactersComponent(): AllCharactersComponent = allCharactersComponent
        ?: appComponent.allCharactersComponent()
            .build().also {
                allCharactersComponent = it
            }

    fun clearAllCharactersComponent() {
        allCharactersComponent = null
    }

    fun plusCharacterComponent(): CharacterComponent = characterComponent
        ?: appComponent.characterComponent()
            .build().also {
                characterComponent = it
            }

    fun clearCharacterComponent() {
        characterComponent = null
    }

    fun plusAllHousesComponent(): AllHousesComponent = allHousesComponent
        ?: appComponent.allHousesComponent()
            .build().also {
                allHousesComponent = it
            }

    fun clearAllHousesComponent() {
        allHousesComponent = null
    }

    fun plusHouseComponent(): HouseComponent = houseComponent
        ?: appComponent.houseComponent()
            .build().also {
                houseComponent = it
            }

    fun clearHouseComponent() {
        houseComponent = null
    }
}
