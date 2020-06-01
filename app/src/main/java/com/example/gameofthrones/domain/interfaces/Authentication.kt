package com.example.gameofthrones.domain.interfaces

import android.view.View

interface Authentication {
    fun createAccount(email: String, password: String, view: View): Boolean
    fun signIn(email: String, password: String, view: View):Boolean
    fun signOut()
    fun isAuth(): Boolean
    fun getName(collection: String, email: String): String
    fun getEmail(): String
    fun setName(collection: String, map: HashMap<String, String>, document: String)
}
