package com.example.gameofthrones.data.repository

import com.example.gameofthrones.domain.interfaces.DataBase
import com.example.gameofthrones.domain.interfaces.Level3Repository
import com.google.android.gms.tasks.Task
import com.google.firebase.firestore.QuerySnapshot
import javax.inject.Inject

class Level3RepositoryImpl @Inject constructor(
    private val dataBase: DataBase
): Level3Repository {

    override fun getData(collection: String): Task<QuerySnapshot> {
        return dataBase.getData(collection)
    }

    override fun getDataByField(collection: String, field: String, value: String): Task<QuerySnapshot> {
        return dataBase.getDataByField(collection, field, value)
    }

}
