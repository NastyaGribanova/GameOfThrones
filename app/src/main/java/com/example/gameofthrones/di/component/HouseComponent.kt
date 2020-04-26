package com.example.gameofthrones.di.component

import com.example.gameofthrones.di.module.HouseModule
import com.example.gameofthrones.di.module.ViewModelFactoryModule
import com.example.gameofthrones.di.scope.HouseScope
import com.example.gameofthrones.presentation.fragment.HouseFragment
import com.example.gameofthrones.presentation.viewModel.HouseVM
import dagger.Subcomponent

@HouseScope
@Subcomponent(modules = [HouseModule::class])
interface HouseComponent {

    fun inject(houseFragment: HouseFragment)

    @Subcomponent.Builder
    interface Builder {

        fun build(): HouseComponent

    }
}
