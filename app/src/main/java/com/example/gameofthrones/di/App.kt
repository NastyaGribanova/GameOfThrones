package com.example.gameofthrones.di

import android.app.Application

class App: Application() {

    override fun onCreate() {
        super.onCreate()
        AppInjector.init(this)
    }
}
