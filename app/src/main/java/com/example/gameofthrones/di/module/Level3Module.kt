package com.example.gameofthrones.di.module

import androidx.lifecycle.ViewModel
import com.example.gameofthrones.data.repository.Level1RepositoryImpl
import com.example.gameofthrones.data.repository.Level3RepositoryImpl
import com.example.gameofthrones.di.ViewModelKey
import com.example.gameofthrones.di.scope.Level2Scope
import com.example.gameofthrones.di.scope.Level3Scope
import com.example.gameofthrones.domain.interfaces.Level1Repository
import com.example.gameofthrones.domain.interfaces.Level3Repository
import com.example.gameofthrones.presentation.viewModel.quiz.Level2VM
import com.example.gameofthrones.presentation.viewModel.quiz.Level3VM
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap

@Module
class Level3Module {

    @Level3Scope
    @Provides
    fun provideLevel3Repository(level3Repository: Level3RepositoryImpl)
            : Level3Repository = level3Repository

    @Level3Scope
    @Provides
    @IntoMap
    @ViewModelKey(Level3VM::class)
    fun provideLevel2ViewModel(level1Repository: Level1RepositoryImpl): ViewModel {
        return Level2VM(
            level1Repository
        )
    }
}
