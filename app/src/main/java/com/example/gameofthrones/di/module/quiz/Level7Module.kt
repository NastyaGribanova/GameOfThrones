package com.example.gameofthrones.di.module.quiz

import androidx.lifecycle.ViewModel
import com.example.gameofthrones.data.repository.AuthenticationImpl
import com.example.gameofthrones.data.repository.LevelDBRepositoryImpl
import com.example.gameofthrones.di.ViewModelKey
import com.example.gameofthrones.di.scope.quiz.Level7Scope
import com.example.gameofthrones.domain.interfaces.Authentication
import com.example.gameofthrones.domain.interfaces.DataBase
import com.example.gameofthrones.domain.interfaces.LevelDBRepository
import com.example.gameofthrones.presentation.viewModel.quiz.Level7VM
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap

@Module
class Level7Module {

    @Level7Scope
    @Provides
    fun provideLevel7Repository(level3Repository: LevelDBRepositoryImpl)
            : LevelDBRepository = level3Repository

    @Level7Scope
    @Provides
    fun provideAuthRepository(authRepository: AuthenticationImpl)
            : Authentication = authRepository

    @Level7Scope
    @Provides
    @IntoMap
    @ViewModelKey(Level7VM::class)
    fun provideLevel7ViewModel(
        dataBase: DataBase,
        authentication: Authentication,
        level3Repository: LevelDBRepositoryImpl
    ): ViewModel {
        return Level7VM(
            dataBase, authentication, level3Repository
        )
    }
}
