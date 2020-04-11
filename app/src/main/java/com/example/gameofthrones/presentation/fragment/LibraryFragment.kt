package com.example.gameofthrones.presentation.fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.gameofthrones.R
import com.example.gameofthrones.presentation.recyclers.BooksFragment

class LibraryFragment: Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_library, container, false)
    }

//    fun onBook(view: View) {
//        Navigation.findNavController(view).navigate(R.id.booksFragment)
//    }
//
//    fun onCharacter(view: View) {
//        val intent = Intent(activity, BooksFragment::class.java )
//        startActivity(intent)
//    }
//
//    fun onHouse(view: View) {
//        val intent = Intent(activity, BooksFragment::class.java )
//        startActivity(intent)
//    }

    companion object {
        fun newInstance(): LibraryFragment =
            LibraryFragment()
    }
}