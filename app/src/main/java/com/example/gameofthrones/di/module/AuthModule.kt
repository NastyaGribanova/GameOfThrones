package com.example.gameofthrones.di.module

import androidx.lifecycle.ViewModel
import com.example.gameofthrones.data.repository.AuthenticationImpl
import com.example.gameofthrones.di.ViewModelKey
import com.example.gameofthrones.di.scope.AuthScope
import com.example.gameofthrones.domain.interfaces.Authentication
import com.example.gameofthrones.presentation.viewModel.AuthVM
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap

@Module
class AuthModule {

    @AuthScope
    @Provides
    fun provideAuthentication(authentication: AuthenticationImpl)
            : Authentication = authentication

    @AuthScope
    @Provides
    @IntoMap
    @ViewModelKey(AuthVM::class)
    fun provideAuthViewModel(authentication: AuthenticationImpl): ViewModel {
        return AuthVM(
            authentication
        )
    }
}
