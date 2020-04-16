package com.example.gameofthrones.presentation.recycler.book

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.gameofthrones.domain.model.Book

class BooksAdapter (
    var bookList: List<Book>,
    private val clickLambda: (Book) -> Unit
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
