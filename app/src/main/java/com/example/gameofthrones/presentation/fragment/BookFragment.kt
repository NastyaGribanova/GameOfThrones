package com.example.gameofthrones.presentation.fragment

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.gameofthrones.R
import com.example.gameofthrones.di.AppInjector
import com.example.gameofthrones.presentation.viewModel.BookVM
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.fragment_book.*
import javax.inject.Inject

class BookFragment: Fragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private var model: BookVM? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_book, container, false)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        AppInjector.plusBookComponent().inject(this)
        initViewModel()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val name : String = arguments?.getString("name").toString()
        model?.book(name)
        model?.bookLD?.observe(this, Observer{
            Log.e("ERROR", it.toString())
            tv_name_book.text = it.name
            tv_number_pages.text = it.numberOfPages.toString()
            tv_publisher.text = it.publisher
        })
        model?.errorBookLD?.observe(viewLifecycleOwner, Observer{
            Snackbar.make(
                requireView().findViewById(android.R.id.content),
                it,
                Snackbar.LENGTH_LONG
            ).show()
        })
    }

    fun initViewModel(){
        val viewModel by lazy {
            ViewModelProvider(
                this,
                viewModelFactory
            ).get(BookVM::class.java)
        }
        this.model = viewModel
    }

    override fun onDestroy() {
        super.onDestroy()
        AppInjector.clearBookComponent()
    }

}