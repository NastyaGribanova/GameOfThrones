package com.example.gameofthrones.di.component.quiz

import com.example.gameofthrones.di.module.quiz.Level4Module
import com.example.gameofthrones.di.scope.quiz.Level4Scope
import com.example.gameofthrones.presentation.quiz.Level4Fragment
import dagger.Subcomponent

@Level4Scope
@Subcomponent(modules = [Level4Module::class])
interface Level4Component {

    fun inject(level4Fragment: Level4Fragment)

    @Subcomponent.Builder
    interface Builder {

        fun build(): Level4Component

    }
}
