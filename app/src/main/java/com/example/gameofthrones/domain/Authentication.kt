package com.example.gameofthrones.domain

interface Authentication {
    fun createAccount(email: String, password: String): Boolean
    fun signIn(email: String, password: String):Boolean
    fun signOut()
    fun isAuth(): Boolean
}
