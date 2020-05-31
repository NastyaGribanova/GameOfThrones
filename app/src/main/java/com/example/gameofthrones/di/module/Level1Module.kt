package com.example.gameofthrones.di.module

import androidx.lifecycle.ViewModel
import com.example.gameofthrones.data.repository.Level1RepositoryImpl
import com.example.gameofthrones.di.ViewModelKey
import com.example.gameofthrones.di.scope.Level1Scope
import com.example.gameofthrones.domain.interfaces.Level1Repository
import com.example.gameofthrones.presentation.viewModel.quiz.Level1VM
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap

@Module
class Level1Module {

    @Level1Scope
    @Provides
    fun provideLevel1Repository(level1Repository: Level1RepositoryImpl)
            : Level1Repository = level1Repository

    @Level1Scope
    @Provides
    @IntoMap
    @ViewModelKey(Level1VM::class)
    fun provideLevel1ViewModel(level1Repository: Level1RepositoryImpl): ViewModel {
        return Level1VM(
            level1Repository
        )
    }
}
