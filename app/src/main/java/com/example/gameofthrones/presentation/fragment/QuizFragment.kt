package com.example.gameofthrones.presentation.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.example.gameofthrones.R
import com.example.gameofthrones.domain.Quiz
import com.example.gameofthrones.presentation.viewModel.AllCharactersVM
import kotlinx.android.synthetic.main.fragment_quiz.*


class QuizFragment: Fragment() {

    private val answered: Boolean = false
    //private val model = AllCharactersVM()
    private val quiz = Quiz()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_quiz, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        quiz.getRandomCharacter(tv_name_char.toString())
        var rbSelected: Int = radio_group.checkedRadioButtonId

        btn_next.setOnClickListener {
//            if (!answered) {
//                if (rb_yes.isChecked || rb_no.isChecked) {
//                    model.character(tv_name_char.toString())
//                    model.characterLD.observe(this, Observer {
//                        if (quiz.checkAnswer(it, rbSelected))
//                        {
//
//                        }
//                    })
//
//                } else {
//                    Toast.makeText(activity,
//                        "Please select an answer",
//                        Toast.LENGTH_SHORT
//                    ).show()
//                }
//            } else {
//                quiz.showNextCharacter()
//            }
        }

    }

    companion object {
        fun newInstance(): QuizFragment =
            QuizFragment()
    }
}