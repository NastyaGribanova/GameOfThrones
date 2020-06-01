package com.example.gameofthrones.data.repository

import com.example.gameofthrones.domain.interfaces.DataBase
import com.google.android.gms.tasks.Task
import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.QuerySnapshot
import java.util.HashMap
import javax.inject.Inject

class DataBaseImpl @Inject constructor(
    private val db: FirebaseFirestore
): DataBase{
    override fun data(collection: String) : CollectionReference {
        return db.collection(collection)
    }

    override fun getData(collection: String): Task<QuerySnapshot> {
        return db.collection(collection).get()
    }

    override fun setData(collection: String, map: HashMap<String, String>, document: String){
        db.collection(collection).document(document).set(map)
    }

    override fun getDataByField(collection: String, field: String, value: String): Task<QuerySnapshot> {
        return db.collection(collection).whereEqualTo(field, value).get()
    }
}
