package com.example.gameofthrones.presentation.viewModel.quiz

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.gameofthrones.domain.interfaces.Level3Repository
import com.example.gameofthrones.domain.model.AryaList
import com.example.gameofthrones.presentation.model.HouseModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class Level3VM(
    private val level3Repository: Level3Repository
): ViewModel()  {

    private val ariaList: MutableLiveData<ArrayList<AryaList>> by lazy { MutableLiveData<ArrayList<AryaList>>() }
    val ariaListLD: LiveData<ArrayList<AryaList>> = ariaList

    private val rightAnswer: MutableLiveData<Boolean> by lazy { MutableLiveData<Boolean>() }
    val rightAnswerLD: LiveData<Boolean> = rightAnswer

    private val rightAnswerNum: MutableLiveData<Int> by lazy { MutableLiveData<Int>() }
    val rightAnswerNumLD: LiveData<Int> = rightAnswerNum

    fun getData(){
        ariaList.value = level3Repository.getData()
    }

    fun checkAnswer(answer: String, name: String){
        rightAnswer.value = level3Repository.victimByName(name)[0].have == answer
    }

    fun checkAnswerNum(answer: String, name: String){
        if (level3Repository.victimByName(name)[0].have == answer){
            rightAnswerNum.value = 1
        }
        if (level3Repository.victimByName(name)[0].have != answer){
            rightAnswerNum.value = 2
        }
    }

    fun getRandomVictim(number: Int, victims: ArrayList<AryaList>): AryaList {
        return victims[number]
    }
}
