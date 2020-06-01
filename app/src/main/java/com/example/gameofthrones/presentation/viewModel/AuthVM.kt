package com.example.gameofthrones.presentation.viewModel

import android.view.View
import androidx.lifecycle.ViewModel
import com.example.gameofthrones.data.repository.AuthenticationImpl

class AuthVM (
    private val authentication: AuthenticationImpl
): ViewModel() {

    fun checkSignIn(email:String, password:String, view: View):Boolean{
        return authentication.signIn(email, password, view)
    }

    fun isAuth(): Boolean {
        return authentication.isAuth()
    }

    fun createAccount(email: String, password: String, view: View): Boolean{
        return authentication.createAccount(email, password, view)
    }

    fun setMap(name: String): HashMap<String, String>{
        return hashMapOf("name" to name)
    }

    fun setName(collection: String, map: HashMap<String, String>, document: String){
        return authentication.setName(collection, map, document)
    }
}
