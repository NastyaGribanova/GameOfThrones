package com.example.gameofthrones.di.module

import androidx.lifecycle.ViewModel
import com.example.gameofthrones.data.repository.HouseRepositoryImpl
import com.example.gameofthrones.di.ViewModelKey
import com.example.gameofthrones.di.scope.HouseScope
import com.example.gameofthrones.domain.interfaces.HouseRepository
import com.example.gameofthrones.presentation.viewModel.HouseVM
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap

@Module
class HouseModule {

    @HouseScope
    @Provides
    fun provideHouseRepository(houseRepository: HouseRepositoryImpl)
            : HouseRepository = houseRepository

    @HouseScope
    @Provides
    @IntoMap
    @ViewModelKey(HouseVM::class)
    fun provideHouseViewModel(houseRepository: HouseRepositoryImpl): ViewModel {
        return HouseVM(
            houseRepository
        )
    }
}
