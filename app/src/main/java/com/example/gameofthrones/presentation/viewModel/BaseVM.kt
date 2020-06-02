package com.example.gameofthrones.presentation.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.gameofthrones.domain.interfaces.Authentication
import com.example.gameofthrones.domain.interfaces.DataBase
import javax.inject.Inject

class BaseVM @Inject constructor(
    private val dataBase: DataBase,
    private val authentication: Authentication
) : ViewModel() {

    private val coins: MutableLiveData<Number> by lazy { MutableLiveData<Number>() }
    val coinsLD: LiveData<Number> = coins

    fun getCoins() {
        dataBase.data("Coins").document(authentication.getEmail()).get().addOnSuccessListener {
            if (it.exists()) {
                coins.value = it.data?.getValue("coins") as Number
            }
        }
    }
}
