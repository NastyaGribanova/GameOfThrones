package com.example.gameofthrones.di.component

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
    fun level1Component(): Level1Component.Builder
    fun level2Component(): Level2Component.Builder
    fun level3Component(): Level3Component.Builder

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: App): Builder

        fun build(): AppComponent
    }
}
