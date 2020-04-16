package com.example.gameofthrones.presentation.recycler.book

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.gameofthrones.R
import com.example.gameofthrones.data.api.BookApi
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.item_book.tv_name

class BooksHolder(
    override val containerView: View,
    private val clickLambda: (BookApi) -> Unit
) : RecyclerView.ViewHolder(containerView), LayoutContainer {

    fun bind(book: BookApi) {
        tv_name.text = book.name

        itemView.setOnClickListener {
            clickLambda(book)
        }
    }

    companion object {
        fun create(parent: ViewGroup, clickLambda: (BookApi) -> Unit) =
            BooksHolder(
                LayoutInflater.from(parent.context).inflate(R.layout.item_book, parent, false),
                clickLambda
            )
    }
}