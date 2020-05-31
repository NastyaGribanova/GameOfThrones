package com.example.gameofthrones.di.component

import com.example.gameofthrones.di.module.AuthModule
import com.example.gameofthrones.di.scope.AuthScope
import com.example.gameofthrones.presentation.fragment.AuthFragment
import dagger.Subcomponent

@AuthScope
@Subcomponent(modules = [AuthModule::class])
interface AuthComponent {

    fun inject(authFragment: AuthFragment)

    @Subcomponent.Builder
    interface Builder{
        fun build(): AuthComponent
    }
}
