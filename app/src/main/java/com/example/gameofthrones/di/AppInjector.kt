package com.example.gameofthrones.di

import com.example.gameofthrones.di.component.*
import com.example.gameofthrones.presentation.App

object AppInjector {

    lateinit var appComponent: AppComponent
    private var authComponent: AuthComponent? = null
    private var allBooksComponent: AllBooksComponent? = null
    private var allCharactersComponent: AllCharactersComponent? = null
    private var allHousesComponent: AllHousesComponent? = null
    private var level1Component: Level1Component? = null
    private var level2Component: Level2Component? = null
    private var level3Component: Level3Component? = null
    private var profileComponent: ProfileComponent? = null

    fun init(app: App) {
        appComponent = DaggerAppComponent.builder()
            .application(app)
            .build()
    }

    fun plusAuthComponent(): AuthComponent = authComponent
        ?: appComponent.authComponent()
            .build().also {
                authComponent = it
            }

    fun clearAuthComponent() {
        authComponent = null
    }

    fun plusAllBooksComponent(): AllBooksComponent = allBooksComponent
        ?: appComponent.allBooksComponent()
            .build().also {
                allBooksComponent = it
            }

    fun clearAllBooksComponent() {
        allBooksComponent = null
    }

    fun plusAllCharactersComponent(): AllCharactersComponent = allCharactersComponent
        ?: appComponent.allCharactersComponent()
            .build().also {
                allCharactersComponent = it
            }

    fun clearAllCharactersComponent() {
        allCharactersComponent = null
    }

    fun plusAllHousesComponent(): AllHousesComponent = allHousesComponent
        ?: appComponent.allHousesComponent()
            .build().also {
                allHousesComponent = it
            }

    fun clearAllHousesComponent() {
        allHousesComponent = null
    }

    fun plusProfileComponent(): ProfileComponent = profileComponent
        ?: appComponent.profileComponent()
            .build().also {
                profileComponent = it
            }

    fun clearProfileComponent() {
        profileComponent = null
    }

    fun plusLevel1Component(): Level1Component = level1Component
        ?: appComponent.level1Component()
            .build().also {
                level1Component = it
            }

    fun clearlevel1Component() {
        level1Component = null
    }

    fun plusLevel2Component(): Level2Component = level2Component
        ?: appComponent.level2Component()
            .build().also {
                level2Component = it
            }

    fun clearlevel2Component() {
        level2Component = null
    }

    fun plusLevel3Component(): Level3Component = level3Component
        ?: appComponent.level3Component()
            .build().also {
                level3Component = it
            }

    fun clearlevel3Component() {
        level3Component = null
    }

}
