package com.example.gameofthrones.di.component

import com.example.gameofthrones.di.App
import com.example.gameofthrones.di.module.ApiFactoryModule
import com.example.gameofthrones.di.scope.ApplicationScope
import dagger.BindsInstance
import dagger.Component

@ApplicationScope
@Component(modules = [ApiFactoryModule::class])
interface AppComponent {

    fun allBooksComponent(): AllBooksComponent.Builder
    fun bookComponent(): BookComponent.Builder
    fun allCharactersComponent(): AllCharactersComponent.Builder
    fun characterComponent(): CharacterComponent.Builder
    fun allHousesComponent(): AllHousesComponent.Builder
    fun houseComponent(): HouseComponent.Builder

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: App): Builder

        fun build(): AppComponent
    }
}
