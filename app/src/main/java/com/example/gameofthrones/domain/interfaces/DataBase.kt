package com.example.gameofthrones.domain.interfaces

import com.google.android.gms.tasks.Task
import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.QuerySnapshot

interface DataBase {
    fun data(collection: String): CollectionReference
    fun getData(collection: String): Task<QuerySnapshot>
    fun setStringData(collection: String, map: HashMap<String, String>, document: String)
    fun setIntData(collection: String, map: HashMap<String, Number>, document: String)
    fun getDataByField(collection: String, field: String, value: String): Task<QuerySnapshot>
}
