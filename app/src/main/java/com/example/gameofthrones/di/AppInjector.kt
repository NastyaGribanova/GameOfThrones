package com.example.gameofthrones.di

import com.example.gameofthrones.di.component.*
import com.example.gameofthrones.di.component.quiz.Level1Component
import com.example.gameofthrones.di.component.quiz.Level2Component
import com.example.gameofthrones.di.component.quiz.Level3Component
import com.example.gameofthrones.di.component.quiz.Level4Component
import com.example.gameofthrones.di.component.quiz.Level5Component
import com.example.gameofthrones.di.component.quiz.Level6Component
import com.example.gameofthrones.di.component.quiz.Level7Component
import com.example.gameofthrones.di.component.quiz.Level8Component
import com.example.gameofthrones.di.component.quiz.Level9Component
import com.example.gameofthrones.di.component.quiz.Level10Component
import com.example.gameofthrones.presentation.App

object AppInjector {

    lateinit var appComponent: AppComponent
    private var authComponent: AuthComponent? = null
    private var allBooksComponent: AllBooksComponent? = null
    private var allCharactersComponent: AllCharactersComponent? = null
    private var allHousesComponent: AllHousesComponent? = null
    private var profileComponent: ProfileComponent? = null
    private var baseComponent: BaseComponent? = null
    private var level1Component: Level1Component? = null
    private var level2Component: Level2Component? = null
    private var level3Component: Level3Component? = null
    private var level4Component: Level4Component? = null
    private var level5Component: Level5Component? = null
    private var level6Component: Level6Component? = null
    private var level7Component: Level7Component? = null
    private var level8Component: Level8Component? = null
    private var level9Component: Level9Component? = null
    private var level10Component: Level10Component? = null

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

    fun plusBaseComponent(): BaseComponent = baseComponent
        ?: appComponent.baseComponent()
            .build().also {
                baseComponent = it
            }

    fun clearBaseComponent() {
        baseComponent = null
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

    fun plusLevel4Component(): Level4Component = level4Component
        ?: appComponent.level4Component()
            .build().also {
                level4Component = it
            }

    fun clearlevel4Component() {
        level4Component = null
    }

    fun plusLevel5Component(): Level5Component = level5Component
        ?: appComponent.level5Component()
            .build().also {
                level5Component = it
            }

    fun clearlevel5Component() {
        level5Component = null
    }

    fun plusLevel6Component(): Level6Component = level6Component
        ?: appComponent.level6Component()
            .build().also {
                level6Component = it
            }

    fun clearlevel6Component() {
        level6Component = null
    }

    fun plusLevel7Component(): Level7Component = level7Component
        ?: appComponent.level7Component()
            .build().also {
                level7Component = it
            }

    fun clearlevel7Component() {
        level7Component = null
    }

    fun plusLevel8Component(): Level8Component = level8Component
        ?: appComponent.level8Component()
            .build().also {
                level8Component = it
            }

    fun clearlevel8Component() {
        level8Component = null
    }

    fun plusLevel9Component(): Level9Component = level9Component
        ?: appComponent.level9Component()
            .build().also {
                level9Component = it
            }

    fun clearlevel9Component() {
        level9Component = null
    }

    fun plusLevel10Component(): Level10Component = level10Component
        ?: appComponent.level10Component()
            .build().also {
                level10Component = it
            }

    fun clearlevel10Component() {
        level10Component = null
    }
}
