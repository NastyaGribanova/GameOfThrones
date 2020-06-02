package com.example.gameofthrones.domain.interfaces

import android.view.View
import com.google.android.gms.tasks.Task
import com.google.firebase.firestore.DocumentSnapshot

interface Authentication {
    fun createAccount(email: String, password: String, view: View): Boolean
    fun signIn(email: String, password: String, view: View): Boolean
    fun signOut()
    fun isAuth(): Boolean
    fun getName(collection: String, email: String): String
    fun getEmail(): String
    fun setName(collection: String, map: HashMap<String, String>, document: String)
    fun setCoins(map: HashMap<String, Number>, document: String)
    fun getCoins(): Task<DocumentSnapshot>
}
