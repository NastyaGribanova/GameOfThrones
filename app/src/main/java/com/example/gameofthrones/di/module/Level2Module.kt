package com.example.gameofthrones.di.module

import androidx.lifecycle.ViewModel
import com.example.gameofthrones.data.repository.Level1RepositoryImpl
import com.example.gameofthrones.di.ViewModelKey
import com.example.gameofthrones.di.scope.Level1Scope
import com.example.gameofthrones.di.scope.Level2Scope
import com.example.gameofthrones.domain.interfaces.Level1Repository
import com.example.gameofthrones.presentation.viewModel.quiz.Level1VM
import com.example.gameofthrones.presentation.viewModel.quiz.Level2VM
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap

@Module
class Level2Module {

    @Level2Scope
    @Provides
    fun provideLevel2Repository(level1Repository: Level1RepositoryImpl)
            : Level1Repository = level1Repository

    @Level2Scope
    @Provides
    @IntoMap
    @ViewModelKey(Level2VM::class)
    fun provideLevel2ViewModel(level1Repository: Level1RepositoryImpl): ViewModel {
        return Level2VM(
            level1Repository
        )
    }
}
