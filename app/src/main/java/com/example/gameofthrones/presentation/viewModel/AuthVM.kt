package com.example.gameofthrones.presentation.viewModel

import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.gameofthrones.data.repository.AuthenticationImpl

class AuthVM(
    private val authentication: AuthenticationImpl
) : ViewModel() {

    private val coins: MutableLiveData<Number> by lazy { MutableLiveData<Number>() }
    val coinsLD: LiveData<Number> = coins

    fun checkSignIn(email: String, password: String, view: View): Boolean {
        return authentication.signIn(email, password, view)
    }

    fun isAuth(): Boolean {
        return authentication.isAuth()
    }

    fun createAccount(email: String, password: String, view: View): Boolean {
        return authentication.createAccount(email, password, view)
    }

    fun setMapString(name: String, field: String): HashMap<String, String> {
        var hashMap = HashMap<String, String>()
        hashMap.put(field, name)
        return hashMap
    }

    fun setMapInt(number: Number, field: String): HashMap<String, Number> {
        var hashMap = HashMap<String, Number>()
        hashMap.put(field, number)
        return hashMap
    }

    fun setCoins(map: HashMap<String, Number>, document: String) {
        authentication.setCoins(map, document)
    }

    fun setName(collection: String, map: HashMap<String, String>, document: String) {
        return authentication.setName(collection, map, document)
    }
}
