package com.example.gameofthrones.presentation.viewModel.quiz

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.gameofthrones.domain.interfaces.Level1Repository
import com.example.gameofthrones.domain.model.House
import com.example.gameofthrones.presentation.model.HouseModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class Level1VM(
    private val level1Repository: Level1Repository
): ViewModel()  {

    private val compositeDisposable = CompositeDisposable()

    private val houses: MutableLiveData<ArrayList<HouseModel>> by lazy { MutableLiveData<ArrayList<HouseModel>>() }
    val housesLD: LiveData<ArrayList<HouseModel>> = houses

    private val houseByName: MutableLiveData<ArrayList<HouseModel>> by lazy { MutableLiveData<ArrayList<HouseModel>>() }
    val housesByNameLD: LiveData<ArrayList<HouseModel>> = houseByName

    private val rightAnswer: MutableLiveData<Boolean> by lazy { MutableLiveData<Boolean>() }
    val rightAnswerLD: LiveData<Boolean> = rightAnswer

    private val rightAnswerNum: MutableLiveData<Int> by lazy { MutableLiveData<Int>() }
    val rightAnswerNumLD: LiveData<Int> = rightAnswerNum

    private fun mapHousesToHousesModel(house: ArrayList<House>): ArrayList<HouseModel> {
        val houseModel = ArrayList<HouseModel>()
        for (houses in house){
            houseModel.add(
                with(houses){
                    HouseModel(name, region, coatOfArms)
                }
            )
        }
        return houseModel
    }

    fun allHouses() {
        compositeDisposable.add(
            level1Repository.getHouses()
                .map {
                    mapHousesToHousesModel(it)
                }
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ result ->
                    houses.value = result
                },
                    { error ->
                        Log.e("ERROR12", error.toString())
                    })
        )
    }

    fun getHouseByName(name: String) {
        compositeDisposable.add(
            level1Repository.houseByName(name)
                .map {
                    mapHousesToHousesModel(it)
                }
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ result ->
                    houseByName.value = result
                },
                    { error ->
                        Log.e("ERROR11", error.toString())
                    })
        )
    }

    fun checkAnswer(answer: String, name: String){
        compositeDisposable.add(
            level1Repository.houseByName(name)
                .map {
                    mapHousesToHousesModel(it)
                }
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ result ->
                    rightAnswer.value = result[0].region == answer
                },
                    { error ->
                        Log.e("ERROR11", error.toString())
                    })
        )
    }

    fun checkAnswerNum(answer: String, name: String){
        compositeDisposable.add(
            level1Repository.houseByName(name)
                .map {
                    mapHousesToHousesModel(it)
                }
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ result ->
                    if (result[0].region == answer){
                        rightAnswerNum.value = 1
                    }
                    if (result[0].region != answer){
                        rightAnswerNum.value = 2
                    }
                },
                    { error ->
                        Log.e("ERROR11", error.toString())
                    })
        )
    }

    fun getRandomHouse(number: Int, houses: ArrayList<HouseModel>):HouseModel {
        return houses[number]
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.clear()
    }

}
