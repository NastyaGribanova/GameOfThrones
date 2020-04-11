package com.example.gameofthrones.presentation.recyclers

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.gameofthrones.data.api.ApiBooksItem

class BooksAdapter (
    var bookList: List<ApiBooksItem>,
    private val clickLambda: (ApiBooksItem) -> Unit
) : RecyclerView.Adapter<BooksHolder>()  {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BooksHolder =
        BooksHolder.create(
            parent,
            clickLambda
        )

    override fun getItemCount(): Int = bookList.size

    override fun onBindViewHolder(holder: BooksHolder, position: Int) =
        holder.bind(bookList[position])
}
