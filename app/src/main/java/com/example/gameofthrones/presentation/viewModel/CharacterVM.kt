package com.example.gameofthrones.presentation.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.gameofthrones.domain.interfaces.CharacterRepository
import com.example.gameofthrones.domain.model.Character
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class CharacterVM(
    private val characterRepository: CharacterRepository
): ViewModel()  {

    private val character: MutableLiveData<Character> by lazy { MutableLiveData<Character>() }
    val characterLD: LiveData<Character> = character

    fun character(name: String) {
        var result = characterRepository.characterByName(name)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ result ->
                character.value = result
            }, {
                    error ->
            })
    }
}
