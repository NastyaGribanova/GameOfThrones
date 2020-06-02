package com.example.gameofthrones.di.module.quiz

import androidx.lifecycle.ViewModel
import com.example.gameofthrones.data.repository.AuthenticationImpl
import com.example.gameofthrones.data.repository.LevelDBRepositoryImpl
import com.example.gameofthrones.di.ViewModelKey
import com.example.gameofthrones.di.scope.quiz.Level4Scope
import com.example.gameofthrones.domain.interfaces.Authentication
import com.example.gameofthrones.domain.interfaces.DataBase
import com.example.gameofthrones.domain.interfaces.LevelDBRepository
import com.example.gameofthrones.presentation.viewModel.quiz.Level4VM
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap

@Module
class Level4Module {

    @Level4Scope
    @Provides
    fun provideLevel4Repository(level3Repository: LevelDBRepositoryImpl)
            : LevelDBRepository = level3Repository

    @Level4Scope
    @Provides
    fun provideAuthRepository(authRepository: AuthenticationImpl)
            : Authentication = authRepository

    @Level4Scope
    @Provides
    @IntoMap
    @ViewModelKey(Level4VM::class)
    fun provideLevel4ViewModel(
        dataBase: DataBase,
        authentication: Authentication,
        level3Repository: LevelDBRepositoryImpl
    ): ViewModel {
        return Level4VM(
            dataBase, authentication, level3Repository
        )
    }
}
