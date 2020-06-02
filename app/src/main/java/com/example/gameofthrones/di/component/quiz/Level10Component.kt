package com.example.gameofthrones.di.component.quiz

import com.example.gameofthrones.di.module.quiz.Level10Module
import com.example.gameofthrones.di.scope.quiz.Level10Scope
import com.example.gameofthrones.presentation.quiz.Level10Fragment
import dagger.Subcomponent

@Level10Scope
@Subcomponent(modules = [Level10Module::class])
interface Level10Component {

    fun inject(level10Fragment: Level10Fragment)

    @Subcomponent.Builder
    interface Builder {

        fun build(): Level10Component

    }
}
