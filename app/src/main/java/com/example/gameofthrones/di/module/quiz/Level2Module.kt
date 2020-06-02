package com.example.gameofthrones.di.module.quiz

import androidx.lifecycle.ViewModel
import com.example.gameofthrones.data.repository.AuthenticationImpl
import com.example.gameofthrones.data.repository.LevelApiRepositoryImpl
import com.example.gameofthrones.di.ViewModelKey
import com.example.gameofthrones.di.scope.quiz.Level2Scope
import com.example.gameofthrones.domain.interfaces.Authentication
import com.example.gameofthrones.domain.interfaces.DataBase
import com.example.gameofthrones.domain.interfaces.LevelApiRepository
import com.example.gameofthrones.presentation.viewModel.quiz.Level2VM
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap

@Module
class Level2Module {

    @Level2Scope
    @Provides
    fun provideLevel2Repository(level1Repository: LevelApiRepositoryImpl)
            : LevelApiRepository = level1Repository

    @Level2Scope
    @Provides
    fun provideAuthRepository(authRepository: AuthenticationImpl)
            : Authentication = authRepository

    @Level2Scope
    @Provides
    @IntoMap
    @ViewModelKey(Level2VM::class)
    fun provideLevel2ViewModel(
        dataBase: DataBase,
        authentication: Authentication,
        level1Repository: LevelApiRepositoryImpl
    ): ViewModel {
        return Level2VM(
            dataBase,
            authentication,
            level1Repository
        )
    }
}
