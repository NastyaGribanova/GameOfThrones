package com.example.gameofthrones.presentation.viewModel

import androidx.lifecycle.ViewModel
import com.example.gameofthrones.domain.interfaces.Authentication

class ProfileVM(
    private val authentication: Authentication
): ViewModel()  {

    fun signOut(){
        return authentication.signOut()
    }

    fun getName(collection: String, email: String): String{
        return authentication.getName(collection, email)
    }

    fun getEmail(): String{
        return authentication.getEmail()
    }

}
