package com.example.gameofthrones.presentation.viewModel

import androidx.lifecycle.ViewModel
import com.example.gameofthrones.domain.Authentication

class ProfileVM(
    private val authentication: Authentication
): ViewModel()  {

    fun signOut(){
        return authentication.signOut()
    }

}
