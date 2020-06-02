package com.example.gameofthrones.di.component.quiz

import com.example.gameofthrones.di.module.quiz.Level6Module
import com.example.gameofthrones.di.scope.quiz.Level6Scope
import com.example.gameofthrones.presentation.quiz.Level6Fragment
import dagger.Subcomponent

@Level6Scope
@Subcomponent(modules = [Level6Module::class])
interface Level6Component {

    fun inject(level6Fragment: Level6Fragment)

    @Subcomponent.Builder
    interface Builder {

        fun build(): Level6Component

    }
}
