package com.example.gameofthrones.presentation.viewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.gameofthrones.domain.interfaces.Authentication
import com.google.firebase.firestore.FirebaseFirestore
import javax.inject.Inject

class ProfileVM @Inject constructor(
    private val db: FirebaseFirestore,
    private val authentication: Authentication
) : ViewModel() {

    private val name: MutableLiveData<String> by lazy { MutableLiveData<String>() }
    val nameLD: LiveData<String> = name

    fun signOut() {
        return authentication.signOut()
    }

    fun getName(collection: String, email: String) {
        db.collection(collection).document(email).get().addOnSuccessListener {
            if (it.exists()) {
                name.value = it.getString("name").toString()
            }
            Log.d("name", it.getString("name").toString())
        }
        Log.d("nameVM", authentication.getName(collection, email))
    }

    fun getEmail(): String {
        return authentication.getEmail()
    }

}
