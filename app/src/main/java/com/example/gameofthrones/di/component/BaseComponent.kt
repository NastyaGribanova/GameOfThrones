package com.example.gameofthrones.di.component

import com.example.gameofthrones.di.module.BaseModule
import com.example.gameofthrones.di.scope.BaseScope
import com.example.gameofthrones.presentation.fragment.BaseFragment
import dagger.Subcomponent

@BaseScope
@Subcomponent(modules = [BaseModule::class])
interface BaseComponent {

    fun inject(baseFragment: BaseFragment)

    @Subcomponent.Builder
    interface Builder {

        fun build(): BaseComponent

    }
}
