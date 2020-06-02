package com.example.gameofthrones.presentation.viewModel.quiz

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.gameofthrones.domain.interfaces.Authentication
import com.example.gameofthrones.domain.interfaces.DataBase
import com.example.gameofthrones.domain.interfaces.LevelApiRepository
import com.example.gameofthrones.domain.model.House
import com.example.gameofthrones.presentation.model.HouseModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class Level1VM @Inject constructor(
    private val dataBase: DataBase,
    private val authentication: Authentication,
    private val levelApiRepository: LevelApiRepository
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

    private val coins: MutableLiveData<Number> by lazy { MutableLiveData<Number>() }
    val coinsLD: LiveData<Number> = coins

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
            levelApiRepository.getHouses()
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
            levelApiRepository.houseByName(name)
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
            levelApiRepository.houseByName(name)
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
            levelApiRepository.houseByName(name)
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

    fun getRandomHouse(number: Int, houses: ArrayList<HouseModel>):HouseModel {
        return houses[number]
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.clear()
    }

}
