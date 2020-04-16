package com.example.gameofthrones.di.module

import androidx.lifecycle.ViewModel
import com.example.gameofthrones.data.repository.CharacterRepositoryImpl
import com.example.gameofthrones.di.ViewModelKey
import com.example.gameofthrones.di.scope.CharacterScope
import com.example.gameofthrones.domain.interfaces.CharacterRepository
import com.example.gameofthrones.presentation.viewModel.CharacterVM
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap

@Module
class CharacterModule {

    @CharacterScope
    @Provides
    fun provideCharacterRepository(characterRepository: CharacterRepositoryImpl)
            : CharacterRepository = characterRepository

    @CharacterScope
    @Provides
    @IntoMap
    @ViewModelKey(CharacterVM::class)
    fun provideCharacterViewModel(characterRepository: CharacterRepositoryImpl): ViewModel {
        return CharacterVM(
            characterRepository
        )
    }
}
