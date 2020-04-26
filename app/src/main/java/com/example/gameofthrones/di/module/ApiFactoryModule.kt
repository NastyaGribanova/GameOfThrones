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
    fun provideApiFactory() = ApiFactory()

    @ApplicationScope
    @Provides
    fun provideCharacterApiService(apiFactory: ApiFactory): CharacterApiService = apiFactory.characterApiService

    @ApplicationScope
    @Provides
    fun provideHouseApiService(apiFactory: ApiFactory): HouseApiService = apiFactory.houseApiService

    @ApplicationScope
    @Provides
    fun provideBookApiService(apiFactory: ApiFactory): BookApiService = apiFactory.bookApiService
}
