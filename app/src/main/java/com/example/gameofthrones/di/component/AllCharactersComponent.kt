package com.example.gameofthrones.di.component

import com.example.gameofthrones.di.module.ViewModelFactoryModule
import com.example.gameofthrones.di.scope.AllCharactersScope
import com.example.gameofthrones.presentation.CharactersFragment
import com.example.gameofthrones.presentation.viewModel.AllCharactersVM
import dagger.Subcomponent

@AllCharactersScope
@Subcomponent(modules = [AllCharactersVM::class, ViewModelFactoryModule::class])
interface AllCharactersComponent {

    fun inject(charactersFragment: CharactersFragment)

    @Subcomponent.Builder
    interface Builder {

        fun build(): AllCharactersComponent

    }
}