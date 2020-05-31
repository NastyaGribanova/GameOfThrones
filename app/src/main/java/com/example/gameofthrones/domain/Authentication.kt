package com.example.gameofthrones.domain

interface Authentication {
    fun createAccount(email: String, password: String): String
    fun signIn(email: String, password: String):String
    fun signOut()
    fun isAuth(): Boolean
}
