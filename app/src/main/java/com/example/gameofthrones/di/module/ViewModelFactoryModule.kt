package com.example.gameofthrones.di.module

import androidx.lifecycle.ViewModelProvider
import com.example.gameofthrones.di.ViewModelFactory
import dagger.Binds
import dagger.Module

@Module
abstract class ViewModelFactoryModule {

    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory
}
