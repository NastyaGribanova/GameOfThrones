package com.example.gameofthrones.presentation

import android.app.Application
import com.example.gameofthrones.di.AppInjector

class App: Application() {

    override fun onCreate() {
        super.onCreate()
        AppInjector.init(this)
    }
}
