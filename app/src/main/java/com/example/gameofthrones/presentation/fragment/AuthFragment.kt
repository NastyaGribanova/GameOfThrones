package com.example.gameofthrones.presentation.fragment

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.gameofthrones.R
import com.example.gameofthrones.di.AppInjector
import com.example.gameofthrones.presentation.viewModel.AuthVM
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.fragment_auth.*
import javax.inject.Inject

class AuthFragment: Fragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private var model: AuthVM? = null
    lateinit var navController: NavController

    override fun onAttach(context: Context) {
        super.onAttach(context)
        AppInjector.plusAuthComponent().inject(this)
        initViewModel()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        navController = activity?.let { Navigation.findNavController(it, R.id.nav_host_fragment) }!!
        return inflater.inflate(R.layout.fragment_auth, container, false)
    }

    fun initViewModel(){
        model = ViewModelProvider(this, viewModelFactory).get(AuthVM::class.java)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        activity?.findViewById<BottomNavigationView>(R.id.btv_main)?.visibility = View.GONE

        if(model?.isAuth() ?:false) {
            Navigation.findNavController(view).navigate(R.id.profileFragment)
        } else  Log.d("IsAuth", "false")

        btn_register.setOnClickListener() { x ->
            if (
                model?.createAccount(et_email.text.toString(), et_password.text.toString())
                    .equals("success")
            ){
                activity?.let {
                    Snackbar.make(
                        it.findViewById(android.R.id.content),
                        "Success",
                        Snackbar.LENGTH_LONG
                    ).show()
                }
                navController.navigate(R.id.action_authFragment_to_profileFragment)
            }
        }
        btn_auth.setOnClickListener() { x ->
            if (
                model?.signIn(et_email.text.toString(), et_password.text.toString())
                    .equals("success")
            ) {
                getActivity()?.let {
                    Snackbar.make(
                        it.findViewById(android.R.id.content),
                        "Success",
                        Snackbar.LENGTH_LONG
                    ).show()
                }
                navController.navigate(R.id.action_authFragment_to_profileFragment)
            }
        }
    }
    override fun onDestroy() {
        super.onDestroy()
        AppInjector.clearAuthComponent()
    }

    companion object {
        fun newInstance() : AuthFragment =
            AuthFragment()
    }
}