package com.example.gameofthrones.di.component

import com.example.gameofthrones.di.component.quiz.*
import com.example.gameofthrones.di.module.*
import com.example.gameofthrones.presentation.App
import com.example.gameofthrones.di.scope.ApplicationScope
import dagger.BindsInstance
import dagger.Component

@ApplicationScope
@Component(modules = [DataBaseModule::class, FirebaseModule::class, AppModule::class, ApiFactoryModule::class, ViewModelFactoryModule::class])
interface AppComponent {

    fun authComponent(): AuthComponent.Builder
    fun allBooksComponent(): AllBooksComponent.Builder
    fun allCharactersComponent(): AllCharactersComponent.Builder
    fun allHousesComponent(): AllHousesComponent.Builder
    fun profileComponent(): ProfileComponent.Builder
    fun baseComponent(): BaseComponent.Builder
    fun level1Component(): Level1Component.Builder
    fun level2Component(): Level2Component.Builder
    fun level3Component(): Level3Component.Builder
    fun level4Component(): Level4Component.Builder
    fun level5Component(): Level5Component.Builder
    fun level6Component(): Level6Component.Builder
    fun level7Component(): Level7Component.Builder
    fun level8Component(): Level8Component.Builder
    fun level9Component(): Level9Component.Builder
    fun level10Component(): Level10Component.Builder

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: App): Builder

        fun build(): AppComponent
    }
}
