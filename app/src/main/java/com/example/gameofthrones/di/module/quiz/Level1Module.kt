package com.example.gameofthrones.di.module.quiz

import androidx.lifecycle.ViewModel
import com.example.gameofthrones.data.repository.AuthenticationImpl
import com.example.gameofthrones.data.repository.LevelApiRepositoryImpl
import com.example.gameofthrones.di.ViewModelKey
import com.example.gameofthrones.di.scope.quiz.Level1Scope
import com.example.gameofthrones.domain.interfaces.Authentication
import com.example.gameofthrones.domain.interfaces.DataBase
import com.example.gameofthrones.domain.interfaces.LevelApiRepository
import com.example.gameofthrones.presentation.viewModel.quiz.Level1VM
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap

@Module
class Level1Module {

    @Level1Scope
    @Provides
    fun provideLevel1Repository(level1Repository: LevelApiRepositoryImpl)
            : LevelApiRepository = level1Repository

    @Level1Scope
    @Provides
    fun provideAuthRepository(authRepository: AuthenticationImpl)
            : Authentication = authRepository

    @Level1Scope
    @Provides
    @IntoMap
    @ViewModelKey(Level1VM::class)
    fun provideLevel1ViewModel(
        dataBase: DataBase,
        authentication: Authentication,
        level1Repository: LevelApiRepositoryImpl
    ): ViewModel {
        return Level1VM(
            dataBase,
            authentication,
            level1Repository
        )
    }
}
