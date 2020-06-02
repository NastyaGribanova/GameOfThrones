package com.example.gameofthrones.di.module.quiz

import androidx.lifecycle.ViewModel
import com.example.gameofthrones.data.repository.AuthenticationImpl
import com.example.gameofthrones.data.repository.LevelDBRepositoryImpl
import com.example.gameofthrones.di.ViewModelKey
import com.example.gameofthrones.di.scope.quiz.Level8Scope
import com.example.gameofthrones.domain.interfaces.Authentication
import com.example.gameofthrones.domain.interfaces.DataBase
import com.example.gameofthrones.domain.interfaces.LevelDBRepository
import com.example.gameofthrones.presentation.viewModel.quiz.Level8VM
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap

@Module
class Level8Module {

    @Level8Scope
    @Provides
    fun provideLevel8Repository(level3Repository: LevelDBRepositoryImpl)
            : LevelDBRepository = level3Repository

    @Level8Scope
    @Provides
    fun provideAuthRepository(authRepository: AuthenticationImpl)
            : Authentication = authRepository

    @Level8Scope
    @Provides
    @IntoMap
    @ViewModelKey(Level8VM::class)
    fun provideLevel8ViewModel(
        dataBase: DataBase,
        authentication: Authentication,
        level3Repository: LevelDBRepositoryImpl
    ): ViewModel {
        return Level8VM(
            dataBase, authentication, level3Repository
        )
    }
}
