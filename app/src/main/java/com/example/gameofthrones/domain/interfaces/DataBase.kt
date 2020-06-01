package com.example.gameofthrones.domain.interfaces

import com.google.android.gms.tasks.Task
import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.QuerySnapshot

interface DataBase {
    fun data(collection: String) : CollectionReference
    fun getData(collection: String): Task<QuerySnapshot>
    fun setData(collection: String, map: HashMap<String, String>, document: String)
    fun getDataByField(collection: String, field: String, value: String): Task<QuerySnapshot>
}
