package com.example.gameofthrones.di.component

import com.example.gameofthrones.di.module.Level1Module
import com.example.gameofthrones.di.module.ProfileModule
import com.example.gameofthrones.di.scope.Level1Scope
import com.example.gameofthrones.di.scope.ProfileScope
import com.example.gameofthrones.presentation.fragment.ProfileFragment
import com.example.gameofthrones.presentation.quiz.Level1Fragment
import dagger.Subcomponent

@ProfileScope
@Subcomponent(modules = [ProfileModule::class])
interface ProfileComponent {

    fun inject(profileFragment: ProfileFragment)

    @Subcomponent.Builder
    interface Builder {

        fun build(): ProfileComponent

    }
}
