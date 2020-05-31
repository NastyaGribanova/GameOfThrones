package com.example.gameofthrones.di.module

import androidx.lifecycle.ViewModel
import com.example.gameofthrones.data.repository.AuthenticationImpl
import com.example.gameofthrones.data.repository.Level1RepositoryImpl
import com.example.gameofthrones.di.ViewModelKey
import com.example.gameofthrones.di.scope.Level1Scope
import com.example.gameofthrones.di.scope.ProfileScope
import com.example.gameofthrones.domain.Authentication
import com.example.gameofthrones.domain.interfaces.Level1Repository
import com.example.gameofthrones.presentation.viewModel.ProfileVM
import com.example.gameofthrones.presentation.viewModel.quiz.Level1VM
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap

@Module
class ProfileModule {

    @ProfileScope
    @Provides
    fun provideProfileAuthentication(authentication: AuthenticationImpl)
            : Authentication = authentication

    @ProfileScope
    @Provides
    @IntoMap
    @ViewModelKey(ProfileVM::class)
    fun provideProfileViewModel(authentication: AuthenticationImpl): ViewModel {
        return ProfileVM(
            authentication
        )
    }
}
