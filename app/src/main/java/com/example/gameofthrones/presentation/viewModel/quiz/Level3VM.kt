package com.example.gameofthrones.presentation.viewModel.quiz

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.gameofthrones.domain.interfaces.Level3Repository
import com.example.gameofthrones.domain.model.AryaList

class Level3VM(
    private val level3Repository: Level3Repository
): ViewModel()  {

    private val ariaList: MutableLiveData<ArrayList<AryaList>> by lazy { MutableLiveData<ArrayList<AryaList>>() }
    val ariaListLD: LiveData<ArrayList<AryaList>> = ariaList

    private val rightAnswerNum: MutableLiveData<Int> by lazy { MutableLiveData<Int>() }
    val rightAnswerNumLD: LiveData<Int> = rightAnswerNum

    fun getData(){
        var victims = ArrayList<AryaList>()
        level3Repository.getData("AriaList").addOnSuccessListener {
            for (document in it) {
                victims.add(AryaList(document.data.getValue("name").toString(),
                    document.data.get("have").toString()))
            }
            ariaList.value = victims
        }
    }

    fun checkAnswers(name: String, answer: String){
        level3Repository.getDataByField("AriaList", "name", name).addOnSuccessListener {
            for (document in it) {
                if(document.data.get("have").toString().equals(answer)){
                    rightAnswerNum.value = 1
                }
                else {
                    rightAnswerNum.value = 2
                }
                Log.d("victim", document.data.toString())
            }

        }
    }

    fun getVictimByName(name: String): AryaList{
        var victim = AryaList(name, "have")
        level3Repository.getDataByField("AriaList", "name", name).addOnSuccessListener {
            for (document in it) {
                victim = AryaList(document.data.getValue("name").toString(),
                    document.data.get("have").toString())
            }
        }
        return victim
    }

    fun getRandomVictim(number: Int, victims: ArrayList<AryaList>): AryaList {
        return victims[number]
    }
}
