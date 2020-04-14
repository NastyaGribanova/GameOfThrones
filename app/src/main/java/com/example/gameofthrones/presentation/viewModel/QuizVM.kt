package com.example.gameofthrones.presentation.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.gameofthrones.data.api.ApiFactory
import com.example.gameofthrones.data.api.ApiItem
import com.example.gameofthrones.data.api.ApiService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class QuizVM : ViewModel() {

    private var service: ApiService = ApiFactory.apiService

    val character: MutableLiveData<ApiItem> by lazy { MutableLiveData<ApiItem>() }
    val characterLD: LiveData<ApiItem> = character

    fun character(name: String?) {
        var result = service.characterByName(name)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ result ->
                character.value = result
            })
    }
}