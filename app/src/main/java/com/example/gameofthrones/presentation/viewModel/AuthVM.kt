package com.example.gameofthrones.presentation.viewModel

import androidx.lifecycle.ViewModel
import com.example.gameofthrones.domain.Authentication

class AuthVM (
    private val authentication: Authentication
): ViewModel() {

    fun isAuth(): Boolean {
        return authentication.isAuth()
    }

    fun signIn(email:String, password:String): String{
        return authentication.signIn(email, password)
    }

    fun createAccount(email: String, password: String): String{
        return authentication.createAccount(email, password)
    }
}
