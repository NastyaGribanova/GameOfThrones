package com.example.gameofthrones.di.module

import androidx.lifecycle.ViewModel
import com.example.gameofthrones.data.repository.AllHousesRepositoryImpl
import com.example.gameofthrones.di.ViewModelKey
import com.example.gameofthrones.di.scope.AllHousesScope
import com.example.gameofthrones.domain.interfaces.AllHousesRepository
import com.example.gameofthrones.presentation.viewModel.AllHousesVM
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap

@Module
class AllHousesModule {

    @AllHousesScope
    @Provides
    fun provideHousesRepository(housesRepository: AllHousesRepositoryImpl)
            : AllHousesRepository = housesRepository

    @AllHousesScope
    @Provides
    @IntoMap
    @ViewModelKey(AllHousesVM::class)
    fun provideHousesViewModel(housesRepository: AllHousesRepositoryImpl): ViewModel {
        return AllHousesVM(
            housesRepository
        )
    }
}
