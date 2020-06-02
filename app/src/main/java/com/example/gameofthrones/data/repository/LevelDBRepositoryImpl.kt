package com.example.gameofthrones.data.repository

import com.example.gameofthrones.domain.interfaces.DataBase
import com.example.gameofthrones.domain.interfaces.LevelDBRepository
import com.google.android.gms.tasks.Task
import com.google.firebase.firestore.QuerySnapshot
import javax.inject.Inject

class LevelDBRepositoryImpl @Inject constructor(
    private val dataBase: DataBase
) : LevelDBRepository {

    override fun getData(collection: String): Task<QuerySnapshot> {
        return dataBase.getData(collection)
    }

    override fun getDataByField(
        collection: String,
        field: String,
        value: String
    ): Task<QuerySnapshot> {
        return dataBase.getDataByField(collection, field, value)
    }

}
