package com.example.gameofthrones.presentation.viewModel

import android.util.Log
import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.gameofthrones.domain.interfaces.AllHousesRepository
import com.example.gameofthrones.domain.model.House
import com.example.gameofthrones.presentation.model.HouseModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import retrofit2.HttpException

class AllHousesVM(
    private val allHousesRepository: AllHousesRepository
): ViewModel() {

    private val compositeDisposable = CompositeDisposable()

    private val houses: MutableLiveData<ArrayList<HouseModel>> by lazy { MutableLiveData<ArrayList<HouseModel>>() }
    val housesLD: LiveData<ArrayList<HouseModel>> = houses
    private val errorHouse: MutableLiveData<String> by lazy { MutableLiveData<String>() }
    val errorHouseLD: LiveData<String> = errorHouse

    private fun mapHousetoHouseModel(house: ArrayList<House>): ArrayList<HouseModel> {
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

    fun getHouseByName(name: String) {
        compositeDisposable.add(
            allHousesRepository.houseByName(name)
                .map {
                    mapHousetoHouseModel(it)
                }
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ result ->
                    houses.value = result
                },
                    { error ->
                        Log.e("ERROR11", error.toString())
                        errorSearchType(error)
                    })
        )
    }

    fun allHouses() {
        compositeDisposable.add(
            allHousesRepository.getHouses()
                .map {
                    mapHousetoHouseModel(it)
                }
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ result ->
                    houses.value = result
                },
                    { error ->
                        errorHouse.value = "no such houses"
                    })
        )
    }

    private fun errorSearchType(error: Throwable) {
        when (error) {
            is java.lang.IllegalArgumentException -> {
                errorHouse.value = "Enter the name"
            }
            is HttpException -> {
                errorHouse.value = "House not found"
            }
        }
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.clear()
    }
}
