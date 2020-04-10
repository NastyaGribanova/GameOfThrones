package com.example.gameofthrones.domain

import com.google.android.gms.auth.api.signin.GoogleSignInAccount

interface Authentication {
    fun createAccount(email: String, password: String): String
    fun signIn(email: String, password: String):String
    fun signInWithGoogle(account: GoogleSignInAccount): String
    fun signOut()
}
