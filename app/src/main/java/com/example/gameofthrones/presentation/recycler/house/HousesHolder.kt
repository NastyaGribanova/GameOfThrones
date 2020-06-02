package com.example.gameofthrones.presentation.recycler.house

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.gameofthrones.R
import com.example.gameofthrones.presentation.model.HouseModel
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.item_house.view.*

class HousesHolder (
    override val containerView: View,
    private val clickLambda: (HouseModel) -> Unit
) : RecyclerView.ViewHolder(containerView), LayoutContainer {

    fun bind(house: HouseModel) {
        containerView.tv_name.text = house.name
        containerView.tv_region.text = house.region
        itemView.setOnClickListener{
            clickLambda(house)
        }
    }

    companion object {
        fun create(parent: ViewGroup, clickLambda: (HouseModel) -> Unit) =
            HousesHolder(
                LayoutInflater.from(parent.context).inflate(
                    R.layout.item_house,
                    parent,
                    false
                ),
                clickLambda
            )
    }
}
