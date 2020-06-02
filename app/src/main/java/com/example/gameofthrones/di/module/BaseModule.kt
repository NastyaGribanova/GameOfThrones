package com.example.gameofthrones.di.module

import androidx.lifecycle.ViewModel
import com.example.gameofthrones.data.repository.AuthenticationImpl
import com.example.gameofthrones.di.ViewModelKey
import com.example.gameofthrones.di.scope.BaseScope
import com.example.gameofthrones.domain.interfaces.Authentication
import com.example.gameofthrones.domain.interfaces.DataBase
import com.example.gameofthrones.presentation.viewModel.BaseVM
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap

@Module
class BaseModule {

    @BaseScope
    @Provides
    fun provideAuthRepository(authRepository: AuthenticationImpl)
            : Authentication = authRepository

    @BaseScope
    @Provides
    @IntoMap
    @ViewModelKey(BaseVM::class)
    fun provideBaseViewModel(dataBase: DataBase, authentication: Authentication): ViewModel {
        return BaseVM(
            dataBase,
            authentication
        )
    }
}
