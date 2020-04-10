package com.example.gameofthrones.domain

import android.net.Uri
import android.util.Log
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.GoogleAuthProvider
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class AuthInteractor (var mAuth: FirebaseAuth) : Authentication {

    private var database: FirebaseDatabase = FirebaseDatabase.getInstance()
    var myRef: DatabaseReference = database.reference

    override fun createAccount(email: String, password: String): String {
        Log.d(TAG, "createAccount:$email")
        var result: String =  ""
        mAuth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {

                    val user: FirebaseUser? = mAuth.currentUser
                    myRef.child("user").child(user?.uid.toString()).setValue(user)

                    Log.d(TAG, "createUserWithEmail:success")
                    result = "success"
                } else {
                    Log.w(TAG, "createUserWithEmail:failure", task.exception)
                    result = "failed"
                }
            }
        return result
    }

    override fun signIn(email: String, password: String): String {
        Log.d(TAG, "signIn:$email")
        var result: String = ""
        mAuth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    result = "success"
                    Log.d(TAG, "signInWithEmail:success")
                } else {
                    result = "failed"
                    Log.w(TAG, "signInWithEmail:failure", task.exception)
                }
            }
        return result
    }

    override fun signInWithGoogle(account: GoogleSignInAccount): String {
        Log.d(TAG, "firebaseAuthWithGoogle:" + account.id!!)
        var result: String =  ""
        val credential = GoogleAuthProvider.getCredential(account.idToken, null)
        mAuth.signInWithCredential(credential)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {

                    val user: FirebaseUser? = mAuth.currentUser
                    myRef.child("user").child(user?.uid.toString()).setValue(user)

                    Log.d(TAG, "signInWithCredential:success")
                    result = "success"

                } else {
                    Log.w(TAG, "signInWithCredential:failure", task.exception)
                    result = "failed"
                }
            }
        return result
    }

    override fun signOut() {
        mAuth.signOut()
    }

    fun getCurrentUser(){
        val user = FirebaseAuth.getInstance().currentUser
        if (user != null) {
            val name = user.displayName
            val email = user.email
            val photoUrl: Uri? = user.photoUrl
            val emailVerified = user.isEmailVerified
            val uid = user.uid
        }
    }

    companion object {
        private const val TAG = "Authorization"
    }
}