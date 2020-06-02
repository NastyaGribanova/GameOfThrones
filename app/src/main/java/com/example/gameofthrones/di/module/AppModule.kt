package com.example.gameofthrones.di.module

import android.content.Context
import com.example.gameofthrones.di.scope.ApplicationScope
import com.example.gameofthrones.presentation.App
import dagger.Module
import dagger.Provides

@Module
class AppModule() {
    @ApplicationScope
    @Provides
    fun provideContext(application: App): Context = application.applicationContext
}
