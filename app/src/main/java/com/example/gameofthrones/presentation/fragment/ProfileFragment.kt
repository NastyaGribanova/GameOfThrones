package com.example.gameofthrones.presentation.fragment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.gameofthrones.R
import com.example.gameofthrones.di.AppInjector
import com.example.gameofthrones.presentation.viewModel.ProfileVM
import com.google.android.material.bottomnavigation.BottomNavigationView
import javax.inject.Inject

class ProfileFragment : Fragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private var model: ProfileVM? = null
    lateinit var navController: NavController

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        navController = activity?.let { Navigation.findNavController(it, R.id.nav_host_fragment) }!!
        return inflater.inflate(R.layout.fragment_profile, container, false)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        AppInjector.plusProfileComponent().inject(this)
        initViewModel()
    }

    fun initViewModel(){
        val viewModel by lazy {
            ViewModelProvider(
                this,
                viewModelFactory
            ).get(ProfileVM::class.java)
        }
        this.model = viewModel
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        activity?.findViewById<BottomNavigationView>(R.id.btv_main)?.visibility = View.VISIBLE
        getData()
        getInterests()
        logout()
    }

    fun logout(){
        val btnCont: Button = requireView().findViewById(R.id.btn_logout)
        btnCont.setOnClickListener(View.OnClickListener {
            model?.signOut()
            navController.navigate(R.id.action_profileFragment_to_authFragment)
        })
    }

    fun getData(){
        val name: TextView = requireView().findViewById(R.id.tv_name)
        name.text = model?.getName("Users", model?.getEmail()!!)
        val email: TextView = requireView().findViewById(R.id.tv_email)
        email.text = model?.getEmail()
    }

    fun getInterests(){
        val favBook: TextView = requireView().findViewById(R.id.tv_fav_book)

        val favChar: TextView = requireView().findViewById(R.id.tv_fav_char)

        val favSeason: TextView = requireView().findViewById(R.id.tv_fav_season)

    }

    companion object {
        fun newInstance(): ProfileFragment =
            ProfileFragment()
    }

    override fun onDestroy() {
        super.onDestroy()
        AppInjector.clearProfileComponent()
    }

}
