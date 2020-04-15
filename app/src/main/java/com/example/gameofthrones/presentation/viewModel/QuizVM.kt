package com.example.gameofthrones.presentation.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.gameofthrones.data.api.ApiFactory
import com.example.gameofthrones.data.api.CharacterApiService
import com.example.gameofthrones.data.api.models.CharacterApi
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class QuizVM : ViewModel() {

    private var service: CharacterApiService = ApiFactory.characterApiService

    private val character: MutableLiveData<CharacterApi> by lazy { MutableLiveData<CharacterApi>() }
    val characterLD: LiveData<CharacterApi> = character

    fun character(name: String?) {
        var result = service.characterByName(name)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ result ->
                character.value = result
            })
    }
}
