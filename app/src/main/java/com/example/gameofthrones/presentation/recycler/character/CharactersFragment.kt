package com.example.gameofthrones.presentation.recycler.character

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.gameofthrones.R
import com.example.gameofthrones.di.AppInjector
import com.example.gameofthrones.presentation.viewModel.AllCharactersVM
import javax.inject.Inject

class CharactersFragment : Fragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private var model: AllCharactersVM? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_characters, container, false)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        AppInjector.plusAllCharactersComponent().inject(this)
        initViewModel()
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

    override fun onDestroy() {
        super.onDestroy()
        AppInjector.clearAllCharactersComponent()
    }

}
