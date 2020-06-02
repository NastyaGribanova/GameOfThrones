package com.example.gameofthrones.di.component

import com.example.gameofthrones.di.module.AllHousesModule
import com.example.gameofthrones.di.scope.AllHousesScope
import com.example.gameofthrones.presentation.recycler.house.HousesFragment
import dagger.Subcomponent

@AllHousesScope
@Subcomponent(modules = [AllHousesModule::class])
interface AllHousesComponent {

    fun inject(housesFragment: HousesFragment)

    @Subcomponent.Builder
    interface Builder {

        fun build(): AllHousesComponent

    }
}
