package com.example.gameofthrones.di.component.quiz

import com.example.gameofthrones.di.module.quiz.Level2Module
import com.example.gameofthrones.di.scope.quiz.Level2Scope
import com.example.gameofthrones.presentation.quiz.Level2Fragment
import dagger.Subcomponent

@Level2Scope
@Subcomponent(modules = [Level2Module::class])
interface Level2Component {

    fun inject(level1Fragment: Level2Fragment)

    @Subcomponent.Builder
    interface Builder {

        fun build(): Level2Component

    }
}
