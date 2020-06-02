package com.example.gameofthrones.di.module

import androidx.lifecycle.ViewModel
import com.example.gameofthrones.data.repository.AllCharactersRepositoryImpl
import com.example.gameofthrones.di.ViewModelKey
import com.example.gameofthrones.di.scope.AllCharactersScope
import com.example.gameofthrones.domain.interfaces.AllCharactersRepository
import com.example.gameofthrones.presentation.viewModel.AllCharactersVM
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap

@Module
class AllCharactersModule {

    @AllCharactersScope
    @Provides
    fun provideCharactersRepository(charactersRepository: AllCharactersRepositoryImpl)
            : AllCharactersRepository = charactersRepository

    @AllCharactersScope
    @Provides
    @IntoMap
    @ViewModelKey(AllCharactersVM::class)
    fun provideCharactersViewModel(charactersRepository: AllCharactersRepositoryImpl): ViewModel {
        return AllCharactersVM(
            charactersRepository
        )
    }
}
