package com.example.gameofthrones.presentation.viewModel

import android.util.Log
import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel
import com.example.gameofthrones.domain.AuthInteractor
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class AuthVM (var mAuth: FirebaseAuth): ViewModel() {

    private var database: FirebaseDatabase = FirebaseDatabase.getInstance()
    var myRef: DatabaseReference = database.reference

//    fun sign(email: String, password: String) : String{
//        if( mAuth.signInWithEmailAndPassword(email, password).isSuccessful)
//            return "success"
//        else
//            return "failed"
//    }
//
//
//
//    fun signIn(email: String, password: String) {
//        var result = sign(email, password)
//            .subscribeOn(Schedulers.io())
//            .observeOn(AndroidSchedulers.mainThread())
//            .subscribe({ result ->
//                result = sign()
//            })
//    }
}
