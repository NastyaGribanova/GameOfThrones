package com.example.gameofthrones.presentation.recycler.character

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.gameofthrones.presentation.model.CharacterModel

class CharactersAdapter (
    private var characters: List<CharacterModel>,
    private var clickLambda: (CharacterModel) -> Unit
) : RecyclerView.Adapter<CharactersHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharactersHolder =
        CharactersHolder.create(parent, clickLambda)

    override fun getItemCount(): Int = characters.size

    override fun onBindViewHolder(holder: CharactersHolder, position: Int) {
        holder.bind(characters[position])
    }
}
