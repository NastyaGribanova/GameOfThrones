package com.example.gameofthrones.presentation.recycler.book

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.gameofthrones.R
import com.example.gameofthrones.presentation.model.BookModel
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.item_book.view.*

class BooksHolder(
    override val containerView: View,
    private val clickLambda: (BookModel) -> Unit
) : RecyclerView.ViewHolder(containerView), LayoutContainer {

    fun bind(book: BookModel) {
        containerView.tv_name.text = book.name
        containerView.tv_publisher.text = book.publisher
        itemView.setOnClickListener {
            clickLambda(book)
        }
    }

    companion object {
        fun create(parent: ViewGroup, clickLambda: (BookModel) -> Unit) =
            BooksHolder(
                LayoutInflater.from(parent.context).inflate(R.layout.item_book, parent, false),
                clickLambda
            )
    }
}
