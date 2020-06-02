package com.example.gameofthrones.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.gameofthrones.R
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        navController = Navigation.findNavController(this, R.id.nav_host_fragment)

        val onNavigationItemSelectedListener =
            BottomNavigationView.OnNavigationItemSelectedListener { item ->
                when (item.itemId) {
                    R.id.base -> {
                        navController.navigate(R.id.baseFragment)
                        true
                    }
                    R.id.quiz -> {
                        navController.navigate(R.id.quizFragment)
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
        navController.navigate(R.id.action_profileFragment_to_booksFragment)
    }

    fun onCharacter(view: View) {
        navController.navigate(R.id.action_profileFragment_to_charactersFragment)
    }

    fun onHouse(view: View) {
        navController.navigate(R.id.action_profileFragment_to_housesFragment)
    }

    fun level1(view: View) {
        navController.navigate(R.id.action_quizFragment_to_level1Fragment)
    }

    fun level2(view: View) {
        navController.navigate(R.id.action_quizFragment_to_level2Fragment)
    }

    fun level3(view: View) {
        navController.navigate(R.id.action_quizFragment_to_level3Fragment)
    }

    fun level4(view: View) {
        navController.navigate(R.id.action_quizFragment_to_level4Fragment)
    }

    fun level5(view: View) {
        navController.navigate(R.id.action_quizFragment_to_level5Fragment)
    }

    fun level6(view: View) {
        navController.navigate(R.id.action_quizFragment_to_level6Fragment)
    }

    fun level7(view: View) {
        navController.navigate(R.id.action_quizFragment_to_level7Fragment)
    }

    fun level8(view: View) {
        navController.navigate(R.id.action_quizFragment_to_level7Fragment)
    }

    fun level9(view: View) {
        navController.navigate(R.id.action_quizFragment_to_level7Fragment)
    }

    fun level10(view: View) {
        navController.navigate(R.id.action_quizFragment_to_level7Fragment)
    }
}
