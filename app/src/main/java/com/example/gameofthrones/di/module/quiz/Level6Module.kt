package com.example.gameofthrones.di.module.quiz

import androidx.lifecycle.ViewModel
import com.example.gameofthrones.data.repository.AuthenticationImpl
import com.example.gameofthrones.data.repository.LevelDBRepositoryImpl
import com.example.gameofthrones.di.ViewModelKey
import com.example.gameofthrones.di.scope.quiz.Level6Scope
import com.example.gameofthrones.domain.interfaces.Authentication
import com.example.gameofthrones.domain.interfaces.DataBase
import com.example.gameofthrones.domain.interfaces.LevelDBRepository
import com.example.gameofthrones.presentation.viewModel.quiz.Level6VM
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap

@Module
class Level6Module {

    @Level6Scope
    @Provides
    fun provideLevel6Repository(level3Repository: LevelDBRepositoryImpl)
            : LevelDBRepository = level3Repository

    @Level6Scope
    @Provides
    fun provideAuthRepository(authRepository: AuthenticationImpl)
            : Authentication = authRepository

    @Level6Scope
    @Provides
    @IntoMap
    @ViewModelKey(Level6VM::class)
    fun provideLevel6ViewModel(
        dataBase: DataBase,
        authentication: Authentication,
        level3Repository: LevelDBRepositoryImpl
    ): ViewModel {
        return Level6VM(
            dataBase, authentication, level3Repository
        )
    }
}
