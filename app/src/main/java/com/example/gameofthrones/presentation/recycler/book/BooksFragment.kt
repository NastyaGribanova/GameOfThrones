package com.example.gameofthrones.presentation.recycler.book

import android.content.Context
import android.os.Bundle
import android.view.*
import android.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import com.example.gameofthrones.R
import com.example.gameofthrones.di.AppInjector
import com.example.gameofthrones.domain.model.Book
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
    val bundle = Bundle()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
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

        val list: ArrayList<Book> = ArrayList()
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
        model?.allBooks()
        model?.booksLD?.observe(viewLifecycleOwner, Observer{
            adapter?.bookList = it
        })
        model?.errorBookLD?.observe(viewLifecycleOwner, Observer{
            Snackbar.make(
                requireView().findViewById(android.R.id.content),
                it,
                Snackbar.LENGTH_LONG
            ).show()
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
        model?.book(query)
        model?.bookLD?.observe(this, Observer{
            try {
                bundle.putString("name", it.name)
                Navigation.findNavController(view!!).navigate(R.id.action_libraryFragment_to_booksFragment, bundle)
            } catch (e: IOException) {
                Snackbar.make(
                    requireView().findViewById(android.R.id.content),
                    "Book wasn't found",
                    Snackbar.LENGTH_LONG
                ).show()
            }
        })
        model?.errorBookLD?.observe(viewLifecycleOwner, Observer{
            Snackbar.make(
                requireView().findViewById(android.R.id.content),
                it,
                Snackbar.LENGTH_LONG
            ).show()
        })
        return false;
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

    override fun onDestroy() {
        super.onDestroy()
        AppInjector.clearAllBooksComponent()
    }

    companion object {
        fun newInstance() =
            BooksFragment()
    }
}
