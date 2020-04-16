package com.example.gameofthrones.di.module

import com.example.gameofthrones.data.api.ApiFactory
import com.example.gameofthrones.data.api.BookApiService
import com.example.gameofthrones.data.api.CharacterApiService
import com.example.gameofthrones.data.api.HouseApiService
import com.example.gameofthrones.di.scope.ApplicationScope
import dagger.Module
import dagger.Provides

@Module
class ApiFactoryModule {

    @ApplicationScope
    @Provides
    fun provideApiFactory() = ApiFactory

    @ApplicationScope
    @Provides
    fun provideCharacterApiService(): CharacterApiService = ApiFactory.characterApiService

    @ApplicationScope
    @Provides
    fun provideHouseApiService(): HouseApiService = ApiFactory.houseApiService

    @ApplicationScope
    @Provides
    fun provideBookApiService(): BookApiService = ApiFactory.bookApiService
}
