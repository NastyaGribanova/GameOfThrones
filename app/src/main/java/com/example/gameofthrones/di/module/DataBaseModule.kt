package com.example.gameofthrones.di.module

import com.example.gameofthrones.data.repository.DataBaseImpl
import com.example.gameofthrones.di.scope.ApplicationScope
import com.example.gameofthrones.domain.interfaces.DataBase
import dagger.Module
import dagger.Provides

@Module
class DataBaseModule {

    @ApplicationScope
    @Provides
    fun provideDataBaseService(dataBase: DataBaseImpl): DataBase = dataBase
}
