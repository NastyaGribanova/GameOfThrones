package com.example.gameofthrones.presentation.recycler.character

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.gameofthrones.R
import com.example.gameofthrones.presentation.model.CharacterModel
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.item_character.view.*

class CharactersHolder (
    override val containerView: View,
    private val clickLambda: (CharacterModel) -> Unit
) : RecyclerView.ViewHolder(containerView), LayoutContainer {

    fun bind(character: CharacterModel) {
        containerView.tv_name.text = character.name
        containerView.tv_died.text = character.died
        itemView.setOnClickListener{
            clickLambda(character)
        }
    }

    companion object {
        fun create(parent: ViewGroup, clickLambda: (CharacterModel) -> Unit) =
            CharactersHolder(
                LayoutInflater.from(parent.context).inflate(
                    R.layout.item_character,
                    parent,
                    false
                ),
                clickLambda
            )
    }
}
