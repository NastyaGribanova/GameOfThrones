package com.example.gameofthrones.presentation.recycler.book

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.gameofthrones.domain.model.Book
import com.example.gameofthrones.presentation.model.BookModel

class BooksAdapter (
    private var bookList: List<BookModel>,
    private val clickLambda: (BookModel) -> Unit
) : RecyclerView.Adapter<BooksHolder>()  {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BooksHolder =
        BooksHolder.create(
            parent,
            clickLambda
        )

    override fun getItemCount(): Int = bookList.size

    override fun onBindViewHolder(holder: BooksHolder, position: Int) {
        holder.bind(bookList[position])
    }
}
