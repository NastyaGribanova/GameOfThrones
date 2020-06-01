package com.example.gameofthrones.di.component

import com.example.gameofthrones.di.module.AllCharactersModule
import com.example.gameofthrones.di.scope.AllCharactersScope
import com.example.gameofthrones.presentation.recycler.character.CharactersFragment
import dagger.Subcomponent

@AllCharactersScope
@Subcomponent(modules = [AllCharactersModule::class])
interface AllCharactersComponent {

    fun inject(charactersFragment: CharactersFragment)

    @Subcomponent.Builder
    interface Builder {

        fun build(): AllCharactersComponent

    }
}
