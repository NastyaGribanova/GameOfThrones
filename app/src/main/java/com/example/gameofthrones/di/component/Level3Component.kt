package com.example.gameofthrones.di.component

import com.example.gameofthrones.di.module.Level2Module
import com.example.gameofthrones.di.module.Level3Module
import com.example.gameofthrones.di.scope.Level2Scope
import com.example.gameofthrones.di.scope.Level3Scope
import com.example.gameofthrones.presentation.quiz.Level2Fragment
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
