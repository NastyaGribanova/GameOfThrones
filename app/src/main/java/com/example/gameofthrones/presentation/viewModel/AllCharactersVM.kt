package com.example.gameofthrones.presentation.viewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.gameofthrones.domain.interfaces.AllCharactersRepository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import com.example.gameofthrones.domain.model.Character
import com.example.gameofthrones.presentation.model.CharacterModel
import io.reactivex.disposables.CompositeDisposable
import retrofit2.HttpException

class AllCharactersVM (
    private val allCharactersRepository: AllCharactersRepository
): ViewModel() {

    private val compositeDisposable = CompositeDisposable()

    private val characters: MutableLiveData<ArrayList<CharacterModel>> by lazy { MutableLiveData<ArrayList<CharacterModel>>() }
    val charactersLD: LiveData<ArrayList<CharacterModel>> = characters

    private val errorCharacter: MutableLiveData<String> by lazy { MutableLiveData<String>() }
    val errorCharacterLD: LiveData<String> = errorCharacter

    private fun mapCharacterToCharModel(character: ArrayList<Character>): ArrayList<CharacterModel> {
        val characterModel = ArrayList<CharacterModel>()
        for (characters in character){
            characterModel.add(
                with(characters){
                    CharacterModel(name, born, gender, died, url)
                }
            )
        }
        return characterModel
    }

    fun getCharacterByName(name: String) {
        compositeDisposable.add(
            allCharactersRepository.characterByName(name)
                .map {
                    mapCharacterToCharModel(it)
                }
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ result ->
                   characters.value = result
                },
                    { error ->
                        Log.e("ERROR11", error.toString())
                        errorSearchType(error)
                    })
        )
    }

    fun getCharacters() {
        compositeDisposable.add(
            allCharactersRepository.getCharacters()
                .map {
                    mapCharacterToCharModel(it)
                }
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ result ->
                    characters.value = result
                },
                    { error ->
                        errorCharacter.value = "no such character"
                    })
        )
    }

    private fun errorSearchType(error: Throwable) {
        when (error) {
            is java.lang.IllegalArgumentException -> {
                errorCharacter.value = "Enter the name"
            }
            is HttpException -> {
                errorCharacter.value = "Character not found"
            }
        }
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.clear()
    }

}

