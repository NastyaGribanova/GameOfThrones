package com.example.gameofthrones.presentation.recycler.book

import android.os.Bundle
import android.view.*
import android.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.Navigation
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import com.example.gameofthrones.R
import com.example.gameofthrones.data.api.BookApi
import com.example.gameofthrones.presentation.viewModel.AllBooksVM
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.fragment_books.*
import java.io.IOException

class BooksFragment: Fragment() {

    private val model = AllBooksVM()
    private var adapter: BooksAdapter? = null
    val bundle = Bundle()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        setHasOptionsMenu(true)
        return inflater.inflate(R.layout.fragment_books, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val list: ArrayList<BookApi> = ArrayList()
        adapter =
            BooksAdapter(
                list
            ) { book ->
                bundle.putString("name", book.name)
                Navigation.findNavController(view)
                    .navigate(R.id.action_libraryFragment_to_booksFragment, bundle)
            }
        rv_books.adapter = adapter

        setRecyclerViewItemTouchListener()
    }

    private fun setRecyclerViewItemTouchListener() {
        val itemTouchCallback = object :
            ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT) {
            override fun onMove(
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder,
                viewHolder1: RecyclerView.ViewHolder
            ): Boolean {
                return false
            }

            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }
        }
        val itemTouchHelper = ItemTouchHelper(itemTouchCallback)
        rv_books.addItemDecoration(itemTouchHelper)
        itemTouchHelper.attachToRecyclerView(rv_books)
        getBooks()
    }

    fun getBooks() {
        model.allBooks()
        model.booksLD.observe(viewLifecycleOwner, Observer{
            adapter?.bookList = it
        })

        adapter?.notifyDataSetChanged()
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater){
        inflater.inflate(R.menu.search_menu, menu)
        val searchItem: MenuItem = menu.findItem(R.id.search)
        val searchView: SearchView = searchItem.actionView as SearchView
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String): Boolean {
                return true
            }

            override fun onQueryTextChange(newText: String): Boolean {
                return false
            }
        })
        super.onCreateOptionsMenu(menu, inflater)
    }

    fun queryTextSubmit(query: String): Boolean {
        model.search(query)
        model.countryLD.observe(this, Observer{
            try {
                bundle.putString("name", it.name)
                Navigation.findNavController(view).navigate(R.id.action_libraryFragment_to_booksFragment, bundle)
            } catch (e: IOException) {
                Snackbar.make(
                    requireView().findViewById(android.R.id.content),
                    "Book wasn't found",
                    Snackbar.LENGTH_LONG
                ).show()
            }
        })
        return false;
    }

    companion object {
        fun newInstance() =
            BooksFragment()
    }
}