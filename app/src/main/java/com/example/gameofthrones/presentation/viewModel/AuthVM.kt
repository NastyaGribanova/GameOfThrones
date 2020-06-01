package com.example.gameofthrones.presentation.viewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.gameofthrones.data.repository.AuthenticationImpl
import com.example.gameofthrones.domain.Authentication
import com.example.gameofthrones.presentation.model.HouseModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class AuthVM (
    private val authentication: AuthenticationImpl
): ViewModel() {

    private val compositeDisposable = CompositeDisposable()

    private val signIn: MutableLiveData<Boolean> by lazy { MutableLiveData<Boolean>() }
    val signInLD: LiveData<Boolean> = signIn

    fun checkSignIn(email:String, password:String){
        signIn.value = authentication.signIn(email, password)
    }

    fun isAuth(): Boolean {
        return authentication.isAuth()
    }

    fun createAccount(email: String, password: String): Boolean{
        return authentication.createAccount(email, password)
    }
}
