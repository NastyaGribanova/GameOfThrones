package com.example.gameofthrones.domain

import com.example.gameofthrones.data.api.models.CharacterApi

class Quiz {

    fun checkAnswer(character: CharacterApi, id: Int) : Boolean{
        return if (character.died == "")
            id != 0
        else
            id == 0
    }

    fun getRandomCharacter(tv: String){

    }

    fun showNextCharacter(){

    }
}