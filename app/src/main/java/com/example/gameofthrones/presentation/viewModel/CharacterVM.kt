package com.example.gameofthrones.presentation.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.gameofthrones.domain.interfaces.CharacterRepository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import com.example.gameofthrones.domain.models.Character

class CharacterVM (
    private val characterRepository: CharacterRepository
): ViewModel() {

    private val character: MutableLiveData<Character> by lazy { MutableLiveData<Character>() }
    val characterLD: LiveData<Character> = character
    private val characters: MutableLiveData<List<Character>> by lazy { MutableLiveData<List<Character>>() }
    val charactersLD: LiveData<List<Character>> = characters

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

    fun allCharacters() {
        var result = characterRepository.getCharacters()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ result ->
                characters.value = result
            }, {
                    error ->
            })
    }
}
