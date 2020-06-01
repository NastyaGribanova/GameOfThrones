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
import kotlinx.android.synthetic.main.fragment_auth.*
import javax.inject.Inject

class AuthFragment : Fragment() {

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

    fun initViewModel() {
        model = ViewModelProvider(this, viewModelFactory).get(AuthVM::class.java)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        activity?.findViewById<BottomNavigationView>(R.id.btv_main)?.visibility = View.GONE

        if (model?.isAuth() ?: false) {
            navController.navigate(R.id.action_authFragment_to_profileFragment)
        } else Log.d("IsAuth", "false")

        btn_register.setOnClickListener() { x ->
            if ((!et_email.text.toString().isEmpty()) && (!et_password.text.toString().isEmpty())) {
                if (model?.createAccount(et_email.text.toString(), et_password.text.toString(), view)!!
                ) {
                    model?.setName("User", model?.setMap(et_name.text.toString())!!, et_email.text.toString())
                    navController.navigate(R.id.action_authFragment_to_profileFragment)
                }
            }
        }
        btn_auth.setOnClickListener() { x ->
            if ((!et_email.text.toString().isEmpty()) && (!et_password.text.toString().isEmpty())) {
                if (model?.checkSignIn(
                        et_email.text.toString(),
                        et_password.text.toString(),
                        view
                    )!!
                ) {
                    model?.setName("User", model?.setMap(et_name.text.toString())!!, et_email.text.toString())
                    Navigation.findNavController(view)
                        .navigate(R.id.action_authFragment_to_profileFragment)
                }
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        AppInjector.clearAuthComponent()
    }

    companion object {
        fun newInstance(): AuthFragment =
            AuthFragment()
    }
}
