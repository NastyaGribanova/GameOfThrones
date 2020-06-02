package com.example.gameofthrones.presentation.recycler.house

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.*
import android.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.gameofthrones.R
import com.example.gameofthrones.di.AppInjector
import com.example.gameofthrones.presentation.model.HouseModel
import com.example.gameofthrones.presentation.viewModel.AllHousesVM
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.fragment_houses.*
import javax.inject.Inject

class HousesFragment : Fragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private var model: AllHousesVM? = null

    private var adapter: HousesAdapter? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        setHasOptionsMenu(true)
        return inflater.inflate(R.layout.fragment_houses, container, false)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        AppInjector.plusAllHousesComponent().inject(this)
        initViewModel()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initObservers()
        model?.allHouses()
    }

    fun initViewModel(){
        val viewModel by lazy {
            ViewModelProvider(
                this,
                viewModelFactory
            ).get(AllHousesVM::class.java)
        }
        this.model = viewModel
    }

    private fun initObservers() {
        model?.housesLD?.observe(viewLifecycleOwner, Observer {
            setAdapter(it)
        })
        model?.errorHouseLD?.observe(viewLifecycleOwner, Observer {
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

    private fun setAdapter(list: List<HouseModel>) {
        rv_houses.layoutManager = LinearLayoutManager(context)
        adapter = HousesAdapter(list){
        }
        rv_houses.adapter = adapter
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
        model?.getHouseByName(query)
        return false;
    }

    override fun onDestroy() {
        super.onDestroy()
        AppInjector.clearAllHousesComponent()
    }
}
