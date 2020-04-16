package com.example.gameofthrones.di

import com.example.gameofthrones.di.component.AppComponent

object AppInjector {

    lateinit var appComponent: AppComponent

    fun init(app: App) {
        appComponent = DaggerAppComponent.builder()
            .application(app)
            .build()
    }
}
