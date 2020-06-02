package com.example.gameofthrones.presentation.recycler.house

import com.example.gameofthrones.presentation.model.HouseModel

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class HousesAdapter (
    private var houses: List<HouseModel>,
    private var clickLambda: (HouseModel) -> Unit
) : RecyclerView.Adapter<HousesHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HousesHolder =
        HousesHolder.create(parent, clickLambda)

    override fun getItemCount(): Int = houses.size

    override fun onBindViewHolder(holder: HousesHolder, position: Int) {
        holder.bind(houses[position])
    }
}
