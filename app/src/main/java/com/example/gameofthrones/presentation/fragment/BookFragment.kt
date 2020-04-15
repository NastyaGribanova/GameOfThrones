package com.example.gameofthrones.presentation.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.example.gameofthrones.R
import com.example.gameofthrones.presentation.viewModel.BookVM
import kotlinx.android.synthetic.main.fragment_book.*

class BookFragment: Fragment() {

    private val model = BookVM()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_book, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val name : String = arguments?.getString("name").toString()
        model.book(name)
        model.bookLD.observe(this, Observer{
            Log.e("ERROR", it.toString())
            tv_name_book.text = it.name
            tv_number_pages.text = "Number of pages: " + it.numberOfPages.toString()
            tv_publisher.text = "Publisher: " + it.publisher.toString()
        })
    }
}