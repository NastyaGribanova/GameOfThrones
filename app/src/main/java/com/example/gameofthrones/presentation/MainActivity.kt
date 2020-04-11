package com.example.gameofthrones.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.gameofthrones.R
import com.example.gameofthrones.presentation.fragment.BaseFragment
import com.example.gameofthrones.presentation.fragment.GameFragment
import com.example.gameofthrones.presentation.fragment.LibraryFragment
import com.example.gameofthrones.presentation.fragment.ProfileFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        navController = Navigation.findNavController(this, R.id.nav_host_fragment)

        val onNavigationItemSelectedListener =
            BottomNavigationView.OnNavigationItemSelectedListener {item ->
                when (item.itemId) {
                    R.id.base -> {
                        navController.navigate(R.id.baseFragment)
                       true
                    }
                    R.id.game -> {
                        navController.navigate(R.id.gameFragment)
                        true
                    }
                    R.id.library -> {
                        navController.navigate(R.id.libraryFragment)
                        true
                    }
                    R.id.profile -> {
                        navController.navigate(R.id.profileFragment)
                        true
                    }
                    else -> false
                }
            }
        btv_main.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener)
    }


    fun onBook(view: View) {
        navController.navigate(R.id.booksFragment)
    }

    fun onCharacter(view: View) {
        navController.navigate(R.id.action_libraryFragment_to_charactersFragment)
    }

    fun onHouse(view: View) {
        navController.navigate(R.id.action_libraryFragment_to_housesFragment)
    }
}
