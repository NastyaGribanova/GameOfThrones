package com.example.gameofthrones.data.repository

import com.example.gameofthrones.data.mapper.mapHouses
import com.example.gameofthrones.domain.interfaces.Level3Repository
import com.example.gameofthrones.domain.model.AryaList
import com.example.gameofthrones.domain.model.House
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import io.reactivex.Single

class Level3RepositoryImpl : Level3Repository {
    val db = Firebase.firestore

    override fun getData(): ArrayList<AryaList> {
        val aryaList = arrayListOf<AryaList>()
        db.collection("AriaList")
            .get()
            .addOnSuccessListener { result ->
                for (document in result) {
                    aryaList.add(AryaList(document.get("name") as String,
                        document.get("have") as String
                    ))
                }
            }
        return aryaList
    }

    override fun victimByName(name: String): ArrayList<AryaList>{
        val aryaList = arrayListOf<AryaList>()
        db.collection("AriaList")
            .get()
            .addOnSuccessListener { result ->
                for (document in result) {
                    if (document.get("name") as String == name){
                        aryaList.add(AryaList(document.get("name") as String,
                            document.get("have") as String))
                    }
                }
            }
        return aryaList
    }
}
