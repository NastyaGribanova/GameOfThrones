package com.example.gameofthrones.di.component

import com.example.gameofthrones.di.module.ViewModelFactoryModule
import com.example.gameofthrones.di.scope.AllHousesScope
import com.example.gameofthrones.presentation.HousesFragment
import com.example.gameofthrones.presentation.viewModel.AllHousesVM
import dagger.Subcomponent

@AllHousesScope
@Subcomponent(modules = [AllHousesVM::class, ViewModelFactoryModule::class])
interface AllHousesComponent {

    fun inject(housesFragment: HousesFragment)

    @Subcomponent.Builder
    interface Builder {

        fun build(): AllHousesComponent

    }
}
