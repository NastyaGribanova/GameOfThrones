package com.example.gameofthrones.di.component.quiz

import com.example.gameofthrones.di.module.quiz.Level8Module
import com.example.gameofthrones.di.scope.quiz.Level8Scope
import com.example.gameofthrones.presentation.quiz.Level8Fragment
import dagger.Subcomponent

@Level8Scope
@Subcomponent(modules = [Level8Module::class])
interface Level8Component {

    fun inject(level8Fragment: Level8Fragment)

    @Subcomponent.Builder
    interface Builder {

        fun build(): Level8Component

    }
}
