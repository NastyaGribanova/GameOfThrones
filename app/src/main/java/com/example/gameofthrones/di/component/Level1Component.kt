package com.example.gameofthrones.di.component

import com.example.gameofthrones.di.module.Level1Module
import com.example.gameofthrones.di.scope.Level1Scope
import com.example.gameofthrones.presentation.quiz.Level1Fragment
import dagger.Subcomponent

@Level1Scope
@Subcomponent(modules = [Level1Module::class])
interface Level1Component {

    fun inject(level1Fragment: Level1Fragment)

    @Subcomponent.Builder
    interface Builder {

        fun build(): Level1Component

    }
}
