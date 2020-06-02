package com.example.gameofthrones.presentation.viewModel.quiz

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.gameofthrones.domain.interfaces.Authentication
import com.example.gameofthrones.domain.interfaces.DataBase
import com.example.gameofthrones.domain.interfaces.LevelDBRepository
import com.example.gameofthrones.domain.model.Quiz
import javax.inject.Inject

class Level7VM @Inject constructor(
    private val dataBase: DataBase,
    private val authentication: Authentication,
    private val levelDBRepository: LevelDBRepository
) : ViewModel() {

    private val questionList: MutableLiveData<ArrayList<Quiz>> by lazy { MutableLiveData<ArrayList<Quiz>>() }
    val questionListLD: LiveData<ArrayList<Quiz>> = questionList

    private val rightAnswer: MutableLiveData<Boolean> by lazy { MutableLiveData<Boolean>() }
    val rightAnswerLD: LiveData<Boolean> = rightAnswer

    private val rightAnswerNum: MutableLiveData<Int> by lazy { MutableLiveData<Int>() }
    val rightAnswerNumLD: LiveData<Int> = rightAnswerNum

    private val coins: MutableLiveData<Number> by lazy { MutableLiveData<Number>() }
    val coinsLD: LiveData<Number> = coins

    fun getData() {
        var questions = ArrayList<Quiz>()
        levelDBRepository.getData("HouseWords").addOnSuccessListener {
            for (document in it) {
                questions.add(
                    Quiz(
                        document.data.getValue("house").toString(),
                        document.data.get("words").toString()
                    )
                )
            }
            questionList.value = questions
        }
    }

    fun checkAnswersNum(name: String, answer: String) {
        dataBase.data("HouseWords").whereEqualTo("house", name).get()
            .addOnSuccessListener {
                if (it != null) {
                    for (documents in it) {
                        if (documents.getString("words").toString().equals(answer)) {
                            rightAnswerNum.value = 1
                        } else {
                            rightAnswerNum.value = 2
                        }
                    }

                }
            }
    }

    fun setCoins(
        collection: String,
        map: HashMap<String, Number>
    ) {
        dataBase.setIntData(collection, map, authentication.getEmail())
    }

    fun setMap(coins: Number): HashMap<String, Number> {
        var hashMap = HashMap<String, Number>()
        hashMap.put("coins", coins)
        return hashMap
    }

    fun getCoins() {
        dataBase.data("Coins").document(authentication.getEmail()).get().addOnSuccessListener {
            if (it.exists()) {
                coins.value = it.data?.getValue("coins") as Number
            }
        }
    }

    fun checkAnswers(name: String, answer: String) {
        dataBase.data("HouseWords").whereEqualTo("house", name).get()
            .addOnSuccessListener {
                if (it != null) {
                    for (documents in it) {
                        if (documents.getString("words").toString().equals(answer)) {
                            rightAnswer.value = true
                        } else {
                            rightAnswer.value = false
                        }
                    }
                }
            }
    }

    fun getRandomQuestion(number: Int, questions: ArrayList<Quiz>): Quiz {
        return questions[number]
    }
}
