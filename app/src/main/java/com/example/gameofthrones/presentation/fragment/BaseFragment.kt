package com.example.gameofthrones.presentation.fragment

import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.gameofthrones.R
import com.example.gameofthrones.di.AppInjector
import com.example.gameofthrones.presentation.viewModel.BaseVM
import javax.inject.Inject

class BaseFragment : Fragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private var model: BaseVM? = null

    lateinit var dialog: Dialog

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_base, container, false)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        AppInjector.plusBaseComponent().inject(this)
        initViewModel()
    }

    fun initViewModel() {
        val viewModel by lazy {
            ViewModelProvider(
                this,
                viewModelFactory
            ).get(BaseVM::class.java)
        }
        this.model = viewModel
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        rules()

        val back: ConstraintLayout = requireView().findViewById(R.id.base_layout)
        back.setBackgroundResource(R.drawable.img_base1)

        val coins: TextView = requireView().findViewById(R.id.tv_coins)
        model?.getCoins()
        model?.coinsLD?.observe(viewLifecycleOwner, Observer {
            coins.text = it.toString()
            if (it.toString().toInt() in 0..3) {
                back.setBackgroundResource(R.drawable.img_base1)
            }
            if (it.toString().toInt() in 4..7) {
                back.setBackgroundResource(R.drawable.img_base2)
                coins.setTextColor(resources.getColor(R.color.colorPrimaryDark))
            }
            if (it.toString().toInt() in 8..11) {
                back.setBackgroundResource(R.drawable.img_base3)
                coins.setTextColor(resources.getColor(R.color.white))
            }
            if (it.toString().toInt() in 12..16) {
                back.setBackgroundResource(R.drawable.img_base4)
                coins.setTextColor(resources.getColor(R.color.white))
            }
            if (it.toString().toInt() >= 17) {
                back.setBackgroundResource(R.drawable.img_base5)
                coins.setTextColor(resources.getColor(R.color.white))
            }
        })

    }

    fun rules() {
        val rules: ImageView = requireView().findViewById(R.id.img_coin)
        rules.setOnClickListener() {
            dialog()
        }
    }

    fun dialog() {
        dialog = Dialog(context)
        dialog.run {
            requestWindowFeature(Window.FEATURE_NO_TITLE)
            setContentView(R.layout.dialog_rules)
            window.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

            var textDescription: TextView = dialog.findViewById(R.id.tv_description)
            textDescription.setText(R.string.rules)

            setCancelable(false)
        }

        var btnClose: TextView = dialog.findViewById(R.id.btn_close)
        btnClose.setOnClickListener() {
            dialog.dismiss()
        }
        dialog.show()
    }

    override fun onDestroy() {
        super.onDestroy()
        AppInjector.clearBaseComponent()
    }

    companion object {
        fun newInstance(): BaseFragment =
            BaseFragment()
    }
}
