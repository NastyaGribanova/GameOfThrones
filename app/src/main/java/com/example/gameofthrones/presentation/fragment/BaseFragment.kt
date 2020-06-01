package com.example.gameofthrones.presentation.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.Fragment
import com.example.gameofthrones.R

class BaseFragment: Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_base, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var back: ConstraintLayout = requireView().findViewById(R.id.base_layout)
        back.setBackgroundResource(R.drawable.img_base1)
    }

        companion object {
        fun newInstance(): BaseFragment =
            BaseFragment()
    }
}
