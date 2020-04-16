package com.example.gameofthrones.di.component

import com.example.gameofthrones.di.module.ViewModelFactoryModule
import com.example.gameofthrones.di.scope.CharacterScope
import com.example.gameofthrones.presentation.fragment.CharacterFragment
import com.example.gameofthrones.presentation.viewModel.CharacterVM
import dagger.Subcomponent

@CharacterScope
@Subcomponent(modules = [CharacterVM::class, ViewModelFactoryModule::class])
interface CharacterComponent {

    fun inject(characterFragment: CharacterFragment)

    @Subcomponent.Builder
    interface Builder {

        fun build(): CharacterComponent

    }
}
