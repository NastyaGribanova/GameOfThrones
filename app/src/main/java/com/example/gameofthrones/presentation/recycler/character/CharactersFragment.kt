package com.example.gameofthrones.presentation.recycler.character

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.*
import android.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.navigation.fragment.NavHostFragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.gameofthrones.R
import com.example.gameofthrones.di.AppInjector
import com.example.gameofthrones.domain.model.Character
import com.example.gameofthrones.presentation.model.CharacterModel
import com.example.gameofthrones.presentation.viewModel.AllCharactersVM
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.fragment_characters.*
import javax.inject.Inject

class CharactersFragment : Fragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private var model: AllCharactersVM? = null

    private var adapter: CharactersAdapter? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        setHasOptionsMenu(true)
        return inflater.inflate(R.layout.fragment_characters, container, false)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        AppInjector.plusAllCharactersComponent().inject(this)
        initViewModel()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initObservers()
        model?.getCharacters()
    }

    fun initViewModel(){
        val viewModel by lazy {
            ViewModelProvider(
                this,
                viewModelFactory
            ).get(AllCharactersVM::class.java)
        }
        this.model = viewModel
    }

    private fun initObservers() {
        model?.charactersLD?.observe(viewLifecycleOwner, Observer {
            setAdapter(it)
        })
        model?.errorCharacterLD?.observe(viewLifecycleOwner, Observer {
            val error = it.toString()
            getActivity()?.let {
                Snackbar.make(
                    it.findViewById(android.R.id.content),
                    error,
                    Snackbar.LENGTH_LONG
                ).show()
            }

        })
    }

    private fun setAdapter(list: List<CharacterModel>) {
        rv_characters.layoutManager = LinearLayoutManager(context)
        adapter = CharactersAdapter(list) {
        }
        rv_characters.adapter = adapter
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
        model?.getCharacterByName(query)
        return false;
    }

    override fun onDestroy() {
        super.onDestroy()
        AppInjector.clearAllCharactersComponent()
    }

}
