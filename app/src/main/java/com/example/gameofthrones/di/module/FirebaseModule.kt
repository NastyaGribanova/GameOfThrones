package com.example.gameofthrones.di.module

import com.example.gameofthrones.di.scope.ApplicationScope
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import dagger.Module
import dagger.Provides

@Module
class FirebaseModule {

    @ApplicationScope
    @Provides
    fun provideFireBaseDataBase(): FirebaseFirestore = Firebase.firestore
}
