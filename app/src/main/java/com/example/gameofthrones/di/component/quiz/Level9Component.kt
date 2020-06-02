package com.example.gameofthrones.di.component.quiz

import com.example.gameofthrones.di.module.quiz.Level9Module
import com.example.gameofthrones.di.scope.quiz.Level9Scope
import com.example.gameofthrones.presentation.quiz.Level9Fragment
import dagger.Subcomponent

@Level9Scope
@Subcomponent(modules = [Level9Module::class])
interface Level9Component {

    fun inject(level9Fragment: Level9Fragment)

    @Subcomponent.Builder
    interface Builder {

        fun build(): Level9Component

    }
}
