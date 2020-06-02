package com.example.gameofthrones.di.component.quiz

import com.example.gameofthrones.di.module.quiz.Level7Module
import com.example.gameofthrones.di.scope.quiz.Level7Scope
import com.example.gameofthrones.presentation.quiz.Level7Fragment
import dagger.Subcomponent

@Level7Scope
@Subcomponent(modules = [Level7Module::class])
interface Level7Component {

    fun inject(level7Fragment: Level7Fragment)

    @Subcomponent.Builder
    interface Builder {

        fun build(): Level7Component

    }
}
