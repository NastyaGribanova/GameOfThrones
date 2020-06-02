package com.example.gameofthrones.di.module.quiz

import androidx.lifecycle.ViewModel
import com.example.gameofthrones.data.repository.AuthenticationImpl
import com.example.gameofthrones.data.repository.LevelDBRepositoryImpl
import com.example.gameofthrones.di.ViewModelKey
import com.example.gameofthrones.di.scope.quiz.Level5Scope
import com.example.gameofthrones.domain.interfaces.Authentication
import com.example.gameofthrones.domain.interfaces.DataBase
import com.example.gameofthrones.domain.interfaces.LevelDBRepository
import com.example.gameofthrones.presentation.viewModel.quiz.Level5VM
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap

@Module
class Level5Module {

    @Level5Scope
    @Provides
    fun provideLevel5Repository(level3Repository: LevelDBRepositoryImpl)
            : LevelDBRepository = level3Repository

    @Level5Scope
    @Provides
    fun provideAuthRepository(authRepository: AuthenticationImpl)
            : Authentication = authRepository

    @Level5Scope
    @Provides
    @IntoMap
    @ViewModelKey(Level5VM::class)
    fun provideLevel5ViewModel(
        dataBase: DataBase,
        authentication: Authentication,
        level3Repository: LevelDBRepositoryImpl
    ): ViewModel {
        return Level5VM(
            dataBase, authentication, level3Repository
        )
    }
}
