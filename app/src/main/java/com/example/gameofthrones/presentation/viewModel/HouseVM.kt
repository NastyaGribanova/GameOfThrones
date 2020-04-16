package com.example.gameofthrones.presentation.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.gameofthrones.domain.interfaces.HouseRepository
import com.example.gameofthrones.domain.model.House
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class HouseVM(
    private val houseRepository: HouseRepository
): ViewModel() {

    private val house: MutableLiveData<House> by lazy { MutableLiveData<House>() }
    val houseLD: LiveData<House> = house

    fun house(name: String) {
        var result = houseRepository.houseByName(name)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ result ->
                house.value = result
            }, {
                    error ->
            })
    }
}
