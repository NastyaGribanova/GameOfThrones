package com.example.gameofthrones.presentation.recycler.book

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.*
import android.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.gameofthrones.R
import com.example.gameofthrones.di.AppInjector
import com.example.gameofthrones.domain.model.Book
import com.example.gameofthrones.presentation.model.BookModel
import com.example.gameofthrones.presentation.viewModel.AllBooksVM
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.fragment_books.*
import java.io.IOException
import javax.inject.Inject

class BooksFragment: Fragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private var model: AllBooksVM? = null

    private var adapter: BooksAdapter? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        setHasOptionsMenu(true)
        return inflater.inflate(R.layout.fragment_books, container, false)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        AppInjector.plusAllBooksComponent().inject(this)
        initViewModel()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initObservers()
        model?.allBooks()
    }

    fun initViewModel(){
        val viewModel by lazy {
            ViewModelProvider(
                this,
                viewModelFactory
            ).get(AllBooksVM::class.java)
        }
        this.model = viewModel
    }

    private fun initObservers() {
        model?.booksLD?.observe(viewLifecycleOwner, Observer {
            setAdapter(it)
        })
        model?.errorBookLD?.observe(viewLifecycleOwner, Observer {
            val error = it.toString()
            activity?.let {
                Snackbar.make(
                    it.findViewById(android.R.id.content),
                    error,
                    Snackbar.LENGTH_LONG
                ).show()
            }

        })
    }

    private fun setAdapter(list: List<BookModel>) {
        rv_books.layoutManager = LinearLayoutManager(context)
        adapter = BooksAdapter(list){
        }
        rv_books.adapter = adapter
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater){
        inflater.inflate(R.menu.search_menu, menu)
        val searchItem: MenuItem = menu.findItem(R.id.search)
        val searchView: SearchView = searchItem.actionView as SearchView
        Log.e("MENU", "open")
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String): Boolean {
                queryTextSubmit(query)
                return true
            }

            override fun onQueryTextChange(newText: String): Boolean {
                return false
            }
        })
        super.onCreateOptionsMenu(menu, inflater)
    }

    fun queryTextSubmit(query: String): Boolean {
        model?.getBookByName(query)
        return false;
    }

    override fun onDestroy() {
        super.onDestroy()
        AppInjector.clearAllBooksComponent()
    }
}
