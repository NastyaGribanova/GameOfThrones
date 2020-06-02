package com.example.gameofthrones.di.component.quiz

import com.example.gameofthrones.di.module.quiz.Level3Module
import com.example.gameofthrones.di.scope.quiz.Level3Scope
import com.example.gameofthrones.presentation.quiz.Level3Fragment
import dagger.Subcomponent

@Level3Scope
@Subcomponent(modules = [Level3Module::class])
interface Level3Component {

    fun inject(level3Fragment: Level3Fragment)

    @Subcomponent.Builder
    interface Builder {

        fun build(): Level3Component

    }
}
