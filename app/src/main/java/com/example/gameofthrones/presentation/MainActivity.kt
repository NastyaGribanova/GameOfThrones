package com.example.gameofthrones.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.gameofthrones.R
import com.example.gameofthrones.presentation.fragment.BaseFragment
import com.example.gameofthrones.presentation.fragment.GameFragment
import com.example.gameofthrones.presentation.fragment.ProfileFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val onNavigationItemSelectedListener =
            BottomNavigationView.OnNavigationItemSelectedListener {item ->
                when (item.itemId) {
                    R.id.base -> {
                        val baseFragment = BaseFragment.newInstance()
                        openFragment(baseFragment)
                        true
                    }
                    R.id.game -> {
                        val gameFragment = GameFragment.newInstance()
                        openFragment(gameFragment)
                        true
                    }
                    R.id.profile -> {
                        val profileFragment = ProfileFragment.newInstance()
                        openFragment(profileFragment)
                        true
                    }
                    else -> false
                }
            }
        btv_main.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener)
    }

    private fun openFragment(fragment: Fragment){
        val transaction = supportFragmentManager.beginTransaction().apply { }
        transaction.replace(R.id.container_main, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }

}
