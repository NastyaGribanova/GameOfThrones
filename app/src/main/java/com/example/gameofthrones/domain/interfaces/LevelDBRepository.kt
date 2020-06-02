package com.example.gameofthrones.domain.interfaces

import com.google.android.gms.tasks.Task
import com.google.firebase.firestore.QuerySnapshot

interface LevelDBRepository {
    fun getData(collection: String): Task<QuerySnapshot>
    fun getDataByField(collection: String, field: String, value: String): Task<QuerySnapshot>
}
