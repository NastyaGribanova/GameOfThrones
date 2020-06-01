package com.example.gameofthrones.domain.interfaces

import com.example.gameofthrones.domain.model.AryaList
import io.reactivex.Single

interface Level3Repository {
    fun getData(): ArrayList<AryaList>
    fun victimByName(name: String): ArrayList<AryaList>
}
