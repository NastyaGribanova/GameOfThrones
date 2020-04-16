package com.example.gameofthrones.di.component

import com.example.gameofthrones.di.App
import com.example.gameofthrones.di.module.ApiFactoryModule
import com.example.gameofthrones.di.scope.ApplicationScope
import dagger.BindsInstance
import dagger.Component

@ApplicationScope
@Component(modules = [ApiFactoryModule::class])
interface AppComponent {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: App): Builder

        fun build(): AppComponent
    }
}
