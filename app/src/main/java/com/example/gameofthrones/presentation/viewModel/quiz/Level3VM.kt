package com.example.gameofthrones.presentation.viewModel.quiz

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.gameofthrones.domain.interfaces.Authentication
import com.example.gameofthrones.domain.interfaces.DataBase
import com.example.gameofthrones.domain.interfaces.LevelDBRepository
import com.example.gameofthrones.domain.model.Quiz
import javax.inject.Inject

class Level3VM @Inject constructor(
    private val dataBase: DataBase,
    private val authentication: Authentication,
    private val levelDBRepository: LevelDBRepository
): ViewModel()  {

    private val ariaList: MutableLiveData<ArrayList<Quiz>> by lazy { MutableLiveData<ArrayList<Quiz>>() }
    val ariaListLD: LiveData<ArrayList<Quiz>> = ariaList

    private val rightAnswer: MutableLiveData<Boolean> by lazy { MutableLiveData<Boolean>() }
    val rightAnswerLD: LiveData<Boolean> = rightAnswer

    private val rightAnswerNum: MutableLiveData<Int> by lazy { MutableLiveData<Int>() }
    val rightAnswerNumLD: LiveData<Int> = rightAnswerNum

    private val coins: MutableLiveData<Number> by lazy { MutableLiveData<Number>() }
    val coinsLD: LiveData<Number> = coins

    fun getData(){
        var victims = ArrayList<Quiz>()
        levelDBRepository.getData("AriaList").addOnSuccessListener {
            for (document in it) {
                victims.add(Quiz(document.data.getValue("name").toString(),
                    document.data.get("have").toString()))
            }
            ariaList.value = victims
        }
    }

    fun checkAnswersNum(name: String, answer: String){
        dataBase.data("AriaList").document(name).get().addOnSuccessListener {
            if (it.exists()){
                if (it.getString("have").toString().equals(answer)){
                    rightAnswerNum.value = 1
                } else {
                    rightAnswerNum.value = 2
                }
            }
        }
    }

    fun setCoins(
        collection: String,
        map: HashMap<String, Number>) {
        dataBase.setIntData(collection, map, authentication.getEmail())
    }

    fun setMap(coins: Number): HashMap<String, Number>{
        var hashMap = HashMap<String, Number>()
        hashMap.put("coins", coins)
        return hashMap
    }

    fun getCoins(){
        dataBase.data("Coins").document(authentication.getEmail()).get().addOnSuccessListener {
            if (it.exists()){
                coins.value = it.data?.getValue("coins") as Number
            }
        }
    }

    fun checkAnswers(name: String, answer: String){
        dataBase.data("AriaList").document(name).get().addOnSuccessListener {
            rightAnswer.value = it.getString("have").toString().equals(answer)
        }
    }

    fun getRandomVictim(number: Int, victims: ArrayList<Quiz>): Quiz {
        return victims[number]
    }
}
