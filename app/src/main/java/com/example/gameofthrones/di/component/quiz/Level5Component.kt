package com.example.gameofthrones.di.component.quiz

import com.example.gameofthrones.di.module.quiz.Level5Module
import com.example.gameofthrones.di.scope.quiz.Level5Scope
import com.example.gameofthrones.presentation.quiz.Level5Fragment
import dagger.Subcomponent

@Level5Scope
@Subcomponent(modules = [Level5Module::class])
interface Level5Component {

    fun inject(level5Fragment: Level5Fragment)

    @Subcomponent.Builder
    interface Builder {

        fun build(): Level5Component

    }
}
