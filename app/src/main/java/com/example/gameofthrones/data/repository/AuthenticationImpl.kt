package com.example.gameofthrones.data.repository

import android.content.Context
import android.util.Log
import android.view.View
import androidx.navigation.Navigation
import com.example.gameofthrones.R
import com.example.gameofthrones.domain.interfaces.Authentication
import com.example.gameofthrones.domain.interfaces.DataBase
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.firestore.DocumentSnapshot
import javax.inject.Inject

class AuthenticationImpl @Inject constructor(
    val context: Context,
    private val dataBase: DataBase
) : Authentication {

    var mAuth: FirebaseAuth = FirebaseAuth.getInstance()

    override fun createAccount(email: String, password: String, view: View): Boolean {
        var result: Boolean = false
        mAuth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    val user: FirebaseUser? = mAuth.currentUser
                    Log.d(TAG, "createUserWithEmail:success")
                    result = true
                    Navigation.findNavController(view).navigate(R.id.profileFragment)
                } else {
                    Log.w(TAG, "createUserWithEmail:failure", task.exception)
                    result = false
                }
            }
        return result
    }

    override fun signIn(email: String, password: String, view: View): Boolean {
        var result: Boolean = false
        mAuth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    Log.d(TAG, "signInWithEmail:success")
                    result = true
                    Navigation.findNavController(view).navigate(R.id.profileFragment)
                } else {
                    Log.w(TAG, "signInWithEmail:failure", task.exception)
                    result = false
                }
            }
        return result
    }

    override fun signOut() {
        mAuth.signOut()
    }

    override fun isAuth(): Boolean {
        if (mAuth.currentUser != null) {
            return true
        }
        return false
    }

    override fun getName(collection: String, email: String): String {
        var name: String = ""
        dataBase.data(collection).document(email).get().addOnSuccessListener {
            if (it.exists()) {
                name = it.getString("name").toString()
            }
            Log.d("name", it.getString("name").toString())
            Log.d("nameName", name)
        }
        Log.d("nameNameafter", name)
        return name
    }

    override fun getEmail(): String {
        return mAuth.currentUser?.email ?: "Email"
    }

    override fun setName(
        collection: String,
        map: HashMap<String, String>,
        document: String
    ) {
        dataBase.setStringData(collection, map, document)
    }

    override fun setCoins(map: HashMap<String, Number>, document: String) {
        dataBase.setIntData("Coins", map, document)
    }

    override fun getCoins(): Task<DocumentSnapshot> {
        return dataBase.data("Coins").document(getEmail()).get()
    }

    companion object {
        private const val TAG = "EmailPassword"
    }
}
