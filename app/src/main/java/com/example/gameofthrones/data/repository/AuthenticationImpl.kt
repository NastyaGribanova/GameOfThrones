package com.example.gameofthrones.data.repository

import android.content.Context
import android.util.Log
import com.example.gameofthrones.domain.Authentication
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import javax.inject.Inject

class AuthenticationImpl @Inject constructor(
    val context: Context
): Authentication {

    var mAuth: FirebaseAuth = FirebaseAuth.getInstance()

    private  var database: FirebaseDatabase = FirebaseDatabase.getInstance()
    var myRef: DatabaseReference = database.reference

    override fun createAccount(email: String, password: String): String {
        var result: String =  ""
        mAuth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    val user: FirebaseUser? = mAuth.currentUser
                    //                   myRef.child("user").child(user?.uid.toString()).setValue(user)
                    Log.d(TAG, "createUserWithEmail:success")
                    result = "success"

                } else {
                    Log.w(TAG, "createUserWithEmail:failure", task.exception)
                    result = "failed"
                }
            }
        return result
    }

    override fun signIn(email: String, password: String):String {
        var result: String =  ""
        mAuth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    Log.d(TAG, "signInWithEmail:success")
                    result = "success"

                } else {
                    Log.w(TAG, "signInWithEmail:failure", task.exception)
                    result = "failed"
                }
            }
        return result
    }

    override fun signOut() {
        mAuth.signOut()
    }

    override fun isAuth(): Boolean {
        if(mAuth.currentUser != null){
            return true
        }
        return false
    }

    companion object {
        private const val TAG = "EmailPassword"
    }
}
